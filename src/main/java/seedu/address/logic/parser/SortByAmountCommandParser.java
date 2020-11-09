package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.SortByAmountCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.expense.Order;

/**
 * Parses input arguments and creates a new SortByAmountCommand object
 */
public class SortByAmountCommandParser implements Parser<SortByAmountCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SortByAmountCommand
     * and returns a SortByAmountCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public SortByAmountCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (args.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortByAmountCommand.MESSAGE_USAGE));
        }
        assert !trimmedArgs.isEmpty();

        Order order = ParserUtil.parseOrder(trimmedArgs);

        return new SortByAmountCommand(order);
    }

}
