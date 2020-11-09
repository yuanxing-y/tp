package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_AMOUNT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CATEGORY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;

import seedu.address.model.Model;
import seedu.address.model.expense.Expense;

/**
 * Adds an expense to the expense book.
 */
public class AddExpenseCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an expense to UniSave. \n"
            + "Amount and Category field are compulsory while date and description are optional \n"
            + "Parameters: "
            + PREFIX_AMOUNT + "AMOUNT "
            + PREFIX_CATEGORY + "CATEGORY "
            + PREFIX_DATE + "DATE "
            + PREFIX_DESCRIPTION + "DESCRIPTION \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_AMOUNT + "100 "
            + PREFIX_CATEGORY + "FOODBEVERAGE "
            + PREFIX_DATE + "2 "
            + PREFIX_DESCRIPTION + "yayymovie! ";


    public static final String MESSAGE_SUCCESS = "New expense added: \n%1$s";

    private final Expense toAdd;

    /**
     * Creates an AddExpenseCommand to add the specified {@code Expense}
     */
    public AddExpenseCommand(Expense expense) {
        requireNonNull(expense);
        toAdd = expense;
    }

    /**
     * Executes the add expense command.
     * @param model {@code Model} which the command should operate on.
     * @return A command result in an expense to be added.
     */
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.addExpense(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    /**
     * Checks if a command objects are equal.
     * @param other Another object.
     * @return Whether the 2 command objects are equal or not. Return true if they are equal and false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddExpenseCommand // instanceof handles nulls
                && toAdd.equals(((AddExpenseCommand) other).toAdd));
    }
}
