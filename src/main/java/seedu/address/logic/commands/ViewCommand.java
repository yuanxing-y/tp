package seedu.address.logic.commands;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.expense.Expense;

/**
 * View the expenses in the expense book by the specific index number.
 */
public class ViewCommand extends Command {
    public static final String COMMAND_WORD = "view";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Views the expense identified by the index number used in the displayed expense list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_VIEW_EXPENSE_SUCCESS = "View Expense: %s";

    private final Index targetIndex;

    /**
     * Creates an ViewCommand to view the expenses.
     * @param targetIndex of the expense to be viewed.
     */
    public ViewCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    /**
     * Executes the view command.
     * @param model {@code Model} which the command should operate on.
     * @return A command result in which the specific expense requested by the user is shown.
     * @throws CommandException Throws exception if the index is invalid.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Expense> lastShownList = model.getFilteredExpenseList();

        assert targetIndex.getZeroBased() >= 0 : "index should be a positive number";

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    MESSAGE_USAGE));
        }

        Expense expenseToView = lastShownList.get(targetIndex.getZeroBased());
        String prefix = String.format(MESSAGE_VIEW_EXPENSE_SUCCESS, targetIndex.getOneBased());
        String message = prefix + "\n" + expenseToView.toString();
        return new CommandResult(message);
    }

    /**
     * Checks if a command objects are equal.
     * @param other Another object.
     * @return Whether the 2 command objects are equal or not. Return true if they are equal and false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ViewCommand // instanceof handles nulls
                && targetIndex.equals(((ViewCommand) other).targetIndex)); // state check
    }
}

