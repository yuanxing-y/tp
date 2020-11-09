package seedu.address.logic.commands;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_EXPENSES;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.expense.Description;
import seedu.address.model.expense.Expense;


/**
 * Delete the description of an existing expenses in the expense book.
 */
public class DeleteDescriptionCommand extends Command {

    public static final String COMMAND_WORD = "delete-d";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes the description of the expense identified "
            + "by the index number used in the last expense listing. "
            + "Existing expense will have empty description.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "d/ [DESCRIPTION]\n"
            + "Example: " + COMMAND_WORD + " 1 ";

    public static final String MESSAGE_DELETE_DESCRIPTION_SUCCESS = "Removed description from Expense: \n%1$s";
    private static final Description EMPTY_DESCRIPTION = new Description("");
    private final Index index;

    /**
     * @param index of the expense in the filtered expense list to edit the description
     */
    public DeleteDescriptionCommand(Index index) {
        requireAllNonNull(index);

        this.index = index;
    }

    /**
     * Executes the delete description command.
     * @param model {@code Model} which the command should operate on.
     * @return A command result in the description of the expenses deleted.
     * @throws CommandException Throws exception if the index is invalid.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Expense> lastShownList = model.getFilteredExpenseList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_EXPENSE_DISPLAYED_INDEX);
        }

        Expense expenseToEdit = lastShownList.get(index.getZeroBased());
        assert !expenseToEdit.getDescription().isEmpty() : "Description is already deleted.";

        Expense editedExpense = new Expense(expenseToEdit.getAmount(), expenseToEdit.getDate(),
                expenseToEdit.getCategory(),
                EMPTY_DESCRIPTION);

        model.setExpense(expenseToEdit, editedExpense);
        model.updateFilteredExpenseList(PREDICATE_SHOW_ALL_EXPENSES);

        return new CommandResult(generateSuccessMessage(editedExpense));
    }

    /**
     * Checks if a command objects are equal.
     * @param other Another object.
     * @return Whether the 2 command objects are equal or not. Return true if they are equal and false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeleteDescriptionCommand)) {
            return false;
        }

        // state check
        DeleteDescriptionCommand e = (DeleteDescriptionCommand) other;
        return index.equals(e.index);
    }

    /**
     * Generates a command execution success message based on whether the description is added to or removed from
     * {@code expenseToEdit}.
     */
    private String generateSuccessMessage(Expense expenseToEdit) {
        String message = MESSAGE_DELETE_DESCRIPTION_SUCCESS;
        return String.format(message, expenseToEdit);
    }
}
