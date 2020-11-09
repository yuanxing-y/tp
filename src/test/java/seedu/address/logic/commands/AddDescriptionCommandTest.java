package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalExpenses.getTypicalExpenseBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.ExpenseModelManager;
import seedu.address.model.Model;
import seedu.address.model.UserPrefs;
import seedu.address.model.expense.Description;
import seedu.address.testutil.TypicalExpenses;
import seedu.address.testutil.TypicalIndexes;


/**
 * Contains integration tests (interaction with the Model) for {@code AddDescriptionCommand}.
 */
class AddDescriptionCommandTest {
    private Model model = new ExpenseModelManager(getTypicalExpenseBook(), new UserPrefs());

    @Test
    public void constructor_nullIndexDescription_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddDescriptionCommand(null, null));
    }

    @Test
    public void equals() {
        AddDescriptionCommand addDesFirstCommand =
                new AddDescriptionCommand(TypicalIndexes.INDEX_FIRST_EXPENSE,
                        new Description(CommandTestUtil.VALID_DESCRIPTION_BOOKS));
        AddDescriptionCommand addDesSecondCommand =
                new AddDescriptionCommand(TypicalIndexes.INDEX_SECOND_EXPENSE,
                        new Description(CommandTestUtil.VALID_DESCRIPTION_MOVIE));

        // same object -> returns true
        assertTrue(addDesFirstCommand.equals(addDesFirstCommand));

        // same values -> returns true
        AddDescriptionCommand addDesFirstCommandCopy =
                new AddDescriptionCommand(TypicalIndexes.INDEX_FIRST_EXPENSE,
                        new Description(CommandTestUtil.VALID_DESCRIPTION_BOOKS));
        assertTrue(addDesFirstCommand.equals(addDesFirstCommandCopy));

        AddDescriptionCommand addDesSecondCommandCopy =
                new AddDescriptionCommand(TypicalIndexes.INDEX_SECOND_EXPENSE,
                        new Description(CommandTestUtil.VALID_DESCRIPTION_MOVIE));
        assertTrue(addDesSecondCommand.equals(addDesSecondCommandCopy));
        // different types -> returns false
        assertFalse(addDesFirstCommand.equals(1));

        // null -> returns false
        assertFalse(addDesFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(addDesFirstCommand.equals(addDesSecondCommand));
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {

        Model model = new ExpenseModelManager(TypicalExpenses.getTypicalExpenseBook(), new UserPrefs());

        Index outOfBoundIndex = TypicalIndexes.INDEX_THIRD_EXPENSE;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() > model.getExpenseBook().getExpenseList().size());

        AddDescriptionCommand addDesCommand = new AddDescriptionCommand(outOfBoundIndex,
                new Description(CommandTestUtil.VALID_DESCRIPTION_MOVIE));

        CommandTestUtil.assertCommandFailure(addDesCommand, model, Messages.MESSAGE_INVALID_EXPENSE_DISPLAYED_INDEX);

    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Model model = new ExpenseModelManager(TypicalExpenses.getTypicalExpenseBook(), new UserPrefs());
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredExpenseList().size() + 1);
        AddDescriptionCommand addDesCommand = new AddDescriptionCommand(outOfBoundIndex,
                new Description(CommandTestUtil.VALID_DESCRIPTION_MOVIE));

        CommandTestUtil.assertCommandFailure(addDesCommand, model, Messages.MESSAGE_INVALID_EXPENSE_DISPLAYED_INDEX);
    }

}
