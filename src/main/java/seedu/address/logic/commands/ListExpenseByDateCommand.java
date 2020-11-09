package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.expense.DateContainsKeywordsPredicate;

/**
 * Finds and lists all expenses in expense book whose date matches the keyword.
 * Keyword matching is case sensitive.
 */
public class ListExpenseByDateCommand extends Command {

    public static final String COMMAND_WORD = "filter-t";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Filter all expenses "
            + "by specifying YYYY-MM-DD or DAYSAGO"
            + " and displays them as a list with index numbers.\n"
            + "Parameters: YYYY-MM-DD or DAYSAGO \n"
            + "The parameters of DAYSAGO must be at least zero or below 3650(10 years)\n"
            + "Example: " + COMMAND_WORD + " 2020-10-15 or " + COMMAND_WORD + " 3";
    public static final String MESSAGE_SUCCESS = "Listed all expenses by Date";

    private final DateContainsKeywordsPredicate predicate;

    /**
     * Creates an ListExpenseByDateCommand to list the expenses by the date.
     * @param predicate to list the expenses.
     */
    public ListExpenseByDateCommand(DateContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    /**
     * Executes the list expense by date command.
     * @param model {@code Model} which the command should operate on.
     * @return A command result in which the expenses being listed by the date.
     */
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredExpenseList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_EXPENSES_LISTED_OVERVIEW, model.getFilteredExpenseList().size()));
    }

    /**
     * Checks if a command objects are equal.
     * @param other Another object.
     * @return Whether the 2 command objects are equal or not. Return true if they are equal and false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ListExpenseByDateCommand // instanceof handles nulls
                && predicate.equals(((ListExpenseByDateCommand) other).predicate)); // state check
    }
}
