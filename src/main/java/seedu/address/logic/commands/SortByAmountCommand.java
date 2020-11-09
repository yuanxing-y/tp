package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.expense.Order;

/**
 * Sort the expenses by their the of spending.
 */
public class SortByAmountCommand extends Command {
    public static final String COMMAND_WORD = "sort-a";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sort all existing expenses by descending  "
            + "or ascending amount.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " ascending";

    public static final String MESSAGE_SUCCESS_DESCENDING = "Expenses sorted by descending amount!";

    public static final String MESSAGE_SUCCESS_ASCENDING = "Expenses sorted by ascending amount!";

    public static final String MESSAGE_FAILURE = "The sorting order can only be descending or ascending.\n"
            + "Please specify again!";

    private Order order;

    /**
     * Constructs a SortByAmountCommand object.
     *
     * @param order The order os sorting, which is an Order object.
     */
    public SortByAmountCommand(Order order) {
        this.order = order;
    }

    /**
     * Gets the order of this command object.
     *
     * @return The order of the command object.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Executes the sort by amount command.
     *
     * @param model {@code Model} which the command should operate on.
     * @return A command result in which the message will be shown to users.
     * @throws CommandException Throws exception if the order is not descending or ascending.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (this.order.isAscendingOrder()) {
            model.sortByAscendingAmount();
            return new CommandResult(
                    String.format(MESSAGE_SUCCESS_ASCENDING));
        } else if (this.order.isDescendingOrder()) {
            model.sortByDescendingAmount();
            return new CommandResult(
                    String.format(MESSAGE_SUCCESS_DESCENDING));
        } else {
            throw new CommandException(MESSAGE_FAILURE);
        }
    }

    /**
     * Checks if a command objects are equal.
     *
     * @param other Another object.
     * @return Whether the 2 command objects are equal or not. Return true if they are equal and false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SortByAmountCommand // instanceof handles nulls
                && order.equals(((SortByAmountCommand) other).order)); // state check
    }
}
