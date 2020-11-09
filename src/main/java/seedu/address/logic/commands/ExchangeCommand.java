package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.logic.parser.CliSyntax;
import seedu.address.model.Model;
import seedu.address.model.expense.Currency;
import seedu.address.model.expense.CurrencyConverter;
import seedu.address.model.expense.ExchangeRate;

/**
 * Exchange the currency for the user.
 */
public class ExchangeCommand extends Command {
    public static final String COMMAND_WORD = "exchange";
    public static final String SUCCESSFUL_MESSAGE = "Your expenses is now converted from %s to %s "
            + "at exchange rate %s. \n"
            + "To see a full list of exchange rates adapted by UniSave, use command "
            + "'" + RatesCommand.COMMAND_WORD + "'.\n";
    public static final String MESSAGE_USAGE = "The correct format is: " + COMMAND_WORD
            + " " + CliSyntax.PREFIX_SIGN + "CURRENCY_CODE. "
            + "(e.g. exchange cc/SGD)";
    public static final String MESSAGE_INVALID_CURRENCY = "Please enter a valid currency code!\n"
            + "To see a full list of supported currencies with their currency codes, \n"
            + "type in command '" + CurrenciesCommand.COMMAND_WORD + "'.";

    private final Currency toCurrency;

    /**
     * @param toCurrency of the new currency.
     */
    public ExchangeCommand(Currency toCurrency) {
        requireAllNonNull(toCurrency);
        this.toCurrency = toCurrency;
    }

    /**
     * Executes the exchange command.
     * @param model {@code Model} which the command should operate on.
     * @return A command result in which the expenses being converted to the currency stated by the user.
     */
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        Currency curr = model.getExpenseBookCurrency();
        CurrencyConverter converter = new CurrencyConverter();
        ExchangeRate exchangeRate = converter.convert(curr, toCurrency);
        model.setExpenseBookCurrency(toCurrency);
        model.expenseBookExchange(exchangeRate);
        return new CommandResult(String.format(SUCCESSFUL_MESSAGE, curr, toCurrency, exchangeRate));
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
        if (!(other instanceof ExchangeCommand)) {
            return false;
        }

        // state check
        ExchangeCommand e = (ExchangeCommand) other;
        return toCurrency.equals(e.toCurrency);
    }

}
