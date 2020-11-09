package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.model.ExpenseModelManager;
import seedu.address.model.Model;
import seedu.address.model.UserPrefs;
import seedu.address.testutil.TypicalExpenses;
import seedu.address.testutil.TypicalIndexes;

/**
 * Contains integration tests (interaction with the Model) for {@code ViewExpenseComman}.
 */
public class ViewExpenseCommandTest {

    @Test
    public void equals() {
        ViewCommand viewFirstCommand = new ViewCommand(TypicalIndexes.INDEX_FIRST_EXPENSE);
        ViewCommand viewSecondCommand = new ViewCommand(TypicalIndexes.INDEX_SECOND_EXPENSE);

        // same object -> returns true
        assertTrue(viewFirstCommand.equals(viewFirstCommand));

        // same values -> returns true
        ViewCommand viewFirstCommandCopy = new ViewCommand(TypicalIndexes.INDEX_FIRST_EXPENSE);
        assertTrue(viewFirstCommand.equals(viewFirstCommandCopy));

        // different types -> returns false
        assertFalse(viewFirstCommand.equals(1));

        // null -> returns false
        assertFalse(viewFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(viewFirstCommand.equals(viewSecondCommand));
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {

        Model model = new ExpenseModelManager(TypicalExpenses.getTypicalExpenseBook(), new UserPrefs());

        Index outOfBoundIndex = TypicalIndexes.INDEX_THIRD_EXPENSE;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() > model.getExpenseBook().getExpenseList().size());

        ViewCommand viewCommand = new ViewCommand(outOfBoundIndex);

        CommandTestUtil.assertCommandFailure(viewCommand, model, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ViewCommand.MESSAGE_USAGE));

    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Model model = new ExpenseModelManager(TypicalExpenses.getTypicalExpenseBook(), new UserPrefs());
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredExpenseList().size() + 1);
        ViewCommand viewCommand = new ViewCommand(outOfBoundIndex);

        CommandTestUtil.assertCommandFailure(viewCommand, model, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ViewCommand.MESSAGE_USAGE));
    }

}
