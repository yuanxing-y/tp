package seedu.address.logic.commands;

import seedu.address.model.Model;
import seedu.address.model.expense.Budget;
import seedu.address.model.expense.Currency;
import seedu.address.model.expense.Date;

/**
 * Show the current available budget.
 */
public class ShowBudgetCommand extends Command {

    public static final String COMMAND_WORD = "showBudget";
    public static final String MESSAGE_BUDGET = "Latest budget is: %s %s,";
    public static final String SET_TIME = " set on %s.\n";
    public static final String MESSAGE_REMAINING = "Remaining budget is: %s %s\n";
    public static final String MESSAGE_SETNEW = "Your remaining budget is %s %s, "
            + "seems like you're broke.\n"
            + "Please set a new budget with command: setBudget AMOUNT\n";

    /**
     * Executes the show budget command.
     * @param model {@code Model} which the command should operate on.
     * @return A command result in which the budget of the expense book shown.
     */
    @Override
    public CommandResult execute(Model model) {
        Budget budget = model.getExpenseBookBudget();
        Budget remaining = model.getExpenseBookRemaining();
        Currency currency = model.getExpenseBookCurrency();
        Date setDate = new Date("2020-11-21");
        String budgetMsg = String.format(MESSAGE_BUDGET + SET_TIME, budget, currency, setDate);
        if (model.getExpenseBookRemaining().isEmpty()) {
            String setNew = String.format(MESSAGE_SETNEW, remaining, currency);
            return new CommandResult(budgetMsg + setNew);
        } else {
            String remainingMsg = String.format(MESSAGE_REMAINING, model.getExpenseBookRemaining(), currency);
            return new CommandResult(budgetMsg + remainingMsg);
        }
    }
}
