package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.time.LocalDate;
import java.util.Arrays;

import seedu.address.logic.commands.ListExpenseByDateCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.expense.Date;
import seedu.address.model.expense.DateContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new ListExpenseByDateCommand object
 */
public class ListExpenseByDateCommandParser implements Parser<ListExpenseByDateCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ListExpenseByDateCommand
     * and returns a ListExpenseByDateCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ListExpenseByDateCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListExpenseByDateCommand.MESSAGE_USAGE));
        }
        // check each keywords to either integer or date with 2 dashes
        String[] dateKeywords = trimmedArgs.split("\\s+");
        String[] transformedValidDates = transformValidDate(dateKeywords);
        return new ListExpenseByDateCommand(new DateContainsKeywordsPredicate(Arrays.asList(transformedValidDates)));
    }

    /**
     * Loop through all the inputDate in {@code inputDates} and transform them to validDate with format YYYY-MM-DD.
     * If inputDate is numberOfDaysAgo, it will be transform to validDate by transformDaysAgoToDate.
     * If inputDate is dateWithTwoDashes, it will be transform to validDate by transformDashKeywordToDate.
     * Else throws ParseException.
     * @param inputDates
     * @throws ParseException
     */
    private String[] transformValidDate(String[] inputDates) throws ParseException {
        // create a new array for dates to not modifying original array
        String[] copyDates = new String[inputDates.length];
        for (int i = 0; i < inputDates.length; i++) {
            copyDates[i] = inputDates[i];
        }

        for (int i = 0; i < copyDates.length; i++) {
            String validDate;
            if (!copyDates[i].contains("-")) {
                validDate = transformDaysAgoToDate(copyDates[i]);
            } else {
                validDate = transformDashKeywordToDate(copyDates[i]);
            }
            copyDates[i] = validDate;
        }
        return copyDates;
    }

    /**
     * Transform {@code inputDaysAgo} to a validDate which satisfy YYYY-MM-DD.
     * If {@code inputDaysAgo} is String or integer larger than Date.LARGEST_DAY_AGO or integer lesser than 0,
     * throw ParseException.
     * @param inputDaysAgo String
     * @throws ParseException
     */
    private String transformDaysAgoToDate(String inputDaysAgo) throws ParseException {
        try {
            LocalDate localdate = LocalDate.now();
            int convertedDay = Integer.parseInt(inputDaysAgo);
            if (convertedDay > Date.LARGEST_DAY_AGO || convertedDay < 0) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListExpenseByDateCommand.MESSAGE_USAGE));
            }
            LocalDate dayBefore = localdate.minusDays(convertedDay);
            return dayBefore.toString();
        } catch (Exception e) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListExpenseByDateCommand.MESSAGE_USAGE));
        }
    }

    /**
     * Transform {@code dashKeyword} to a validDate which satisfy YYYY-MM-DD.
     * Only {@code dashKeyword} with 2 dashes and satisfy YYYY-MM-DD is transformed.
     * Else throw ParseException.
     * @param dashKeyword String
     * @throws ParseException
     */
    private String transformDashKeywordToDate(String dashKeyword) throws ParseException {
        try {
            String[] splitDateByDash = dashKeyword.split("-");
            if (splitDateByDash.length != 3) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListExpenseByDateCommand.MESSAGE_USAGE));
            }
            LocalDate parsedDate = LocalDate.parse(dashKeyword);
            return parsedDate.toString();
        } catch (Exception e) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListExpenseByDateCommand.MESSAGE_USAGE));
        }
    }

}
