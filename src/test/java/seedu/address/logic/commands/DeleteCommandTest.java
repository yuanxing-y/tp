package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showExpenseAtIndex;
import static seedu.address.testutil.TypicalExpenses.getTypicalExpenseBook;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_EXPENSE;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.ExpenseModelManager;
import seedu.address.model.Model;
import seedu.address.model.UserPrefs;
import seedu.address.model.expense.Expense;
import seedu.address.testutil.TypicalExpenses;
import seedu.address.testutil.TypicalIndexes;

/**
 * Contains integration tests (interaction with the Model) for {@code DeleteCommand}.
 */
public class DeleteCommandTest {

    private Model model = new ExpenseModelManager(getTypicalExpenseBook(), new UserPrefs());
    @Test
    public void execute_validIndexUnfilteredList_success() {
        Expense expenseToDelete = model.getFilteredExpenseList().get(INDEX_FIRST_EXPENSE.getZeroBased());
        DeleteExpenseCommand deleteCommand = new DeleteExpenseCommand(INDEX_FIRST_EXPENSE);

        String expectedMessage = String.format(DeleteExpenseCommand.MESSAGE_DELETE_EXPENSE_SUCCESS, expenseToDelete);

        ExpenseModelManager expectedModel = new ExpenseModelManager(model.getExpenseBook(), new UserPrefs());
        expectedModel.deleteExpense(expenseToDelete);

        assertCommandSuccess(deleteCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showExpenseAtIndex(model, INDEX_FIRST_EXPENSE);

        Expense personToDelete = model.getFilteredExpenseList().get(INDEX_FIRST_EXPENSE.getZeroBased());
        DeleteExpenseCommand deleteCommand = new DeleteExpenseCommand(INDEX_FIRST_EXPENSE);

        String expectedMessage = String.format(DeleteExpenseCommand.MESSAGE_DELETE_EXPENSE_SUCCESS, personToDelete);

        Model expectedModel = new ExpenseModelManager(model.getExpenseBook(), new UserPrefs());
        expectedModel.deleteExpense(personToDelete);
        showNoExpense(expectedModel);

        assertCommandSuccess(deleteCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void equals() {
        DeleteExpenseCommand deleteFirstCommand = new DeleteExpenseCommand(TypicalIndexes.INDEX_FIRST_EXPENSE);
        DeleteExpenseCommand deleteSecondCommand = new DeleteExpenseCommand(TypicalIndexes.INDEX_SECOND_EXPENSE);

        // same object -> returns true
        assertTrue(deleteFirstCommand.equals(deleteFirstCommand));

        // same values -> returns true
        DeleteExpenseCommand deleteFirstCommandCopy = new DeleteExpenseCommand(TypicalIndexes.INDEX_FIRST_EXPENSE);
        assertTrue(deleteFirstCommand.equals(deleteFirstCommandCopy));

        DeleteExpenseCommand deleteSecondCommandCopy = new DeleteExpenseCommand(TypicalIndexes.INDEX_SECOND_EXPENSE);
        assertTrue(deleteSecondCommand.equals(deleteSecondCommandCopy));

        // different types -> returns false
        assertFalse(deleteFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deleteFirstCommand.equals(null));

        // different expenses -> returns false
        assertFalse(deleteFirstCommand.equals(deleteSecondCommand));
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {

        Model model = new ExpenseModelManager(TypicalExpenses.getTypicalExpenseBook(), new UserPrefs());

        Index outOfBoundIndex = TypicalIndexes.INDEX_THIRD_EXPENSE;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() > model.getExpenseBook().getExpenseList().size());

        DeleteExpenseCommand deleteCommand = new DeleteExpenseCommand(outOfBoundIndex);

        CommandTestUtil.assertCommandFailure(deleteCommand, model, Messages.MESSAGE_INVALID_EXPENSE_DISPLAYED_INDEX);

    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Model model = new ExpenseModelManager(TypicalExpenses.getTypicalExpenseBook(), new UserPrefs());
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredExpenseList().size() + 1);
        DeleteExpenseCommand deleteCommand = new DeleteExpenseCommand(outOfBoundIndex);

        CommandTestUtil.assertCommandFailure(deleteCommand, model, Messages.MESSAGE_INVALID_EXPENSE_DISPLAYED_INDEX);
    }


    /**
     * Updates {@code model}'s filtered list to show no one.
     */
    private void showNoExpense(Model model) {
        model.updateFilteredExpenseList(p -> false);

        assertTrue(model.getFilteredExpenseList().isEmpty());
    }

}
