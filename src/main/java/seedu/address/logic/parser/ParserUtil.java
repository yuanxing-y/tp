package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.commands.SetBudgetCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.expense.Amount;
import seedu.address.model.expense.Budget;
import seedu.address.model.expense.Category;
import seedu.address.model.expense.Currency;
import seedu.address.model.expense.Date;
import seedu.address.model.expense.Description;
import seedu.address.model.expense.Order;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String amount} into a {@code Amount}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code amount} is invalid.
     */
    public static Amount parseAmount(String amount) throws ParseException {
        requireNonNull(amount);
        try {
            double entered = Double.parseDouble(amount.trim());
            if (!Amount.isValidAmount(entered)) {
                throw new ParseException(Amount.MESSAGE_CONSTRAINTS);
            }
            return new Amount(entered);
        } catch (Exception pe) {
            throw new ParseException(Amount.MESSAGE_CONSTRAINTS);
        }
    }

    /**
     * Parses a {@code String amount} into a {@code Amount}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code amount} is invalid.
     */
    public static Amount parseEditAmount(String amount) throws ParseException {
        requireNonNull(amount);
        if (amount.isEmpty()) {
            return new Amount();
        } else {
            try {
                double entered = Double.parseDouble(amount.trim());
                if (!Amount.isValidAmount(entered)) {
                    throw new ParseException(Amount.MESSAGE_CONSTRAINTS);
                }
                return new Amount(entered);
            } catch (Exception pe) {
                throw new ParseException(Amount.MESSAGE_CONSTRAINTS);
            }
        }
    }

    /**
     * Parses a {@code String category} into a {@code Category}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code category} is invalid.
     */
    public static Category parseCategory(String category) throws ParseException {
        requireNonNull(category);
        String trimmedCategory = category.trim();
        if (!Category.isValidCategory(trimmedCategory)) {
            throw new ParseException(Category.MESSAGE_CONSTRAINTS);
        }
        return new Category(trimmedCategory);
    }

    /**
     * Parses a {@code String category} into a {@code Category}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code category} is invalid.
     */
    public static Category parseEditCategory(String category) throws ParseException {
        if (category.isEmpty()) {
            return new Category();
        } else {
            requireNonNull(category);
            String trimmedCategory = category.trim();
            if (!Category.isValidCategory(trimmedCategory)) {
                throw new ParseException(Category.MESSAGE_CONSTRAINTS);
            }
            return new Category(trimmedCategory);
        }
    }

    /**
     * Parses a {@code String date} into a {@code Date}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code date} is invalid.
     */
    public static Date parseDate(String date) throws ParseException {
        requireNonNull(date);
        String trimmedDate = date.trim();
        if (trimmedDate.isEmpty()) {
            return new Date();
        }
        if (!Date.isValidDate(trimmedDate)) {
            throw new ParseException(Date.MESSAGE_CONSTRAINTS);
        }
        return new Date(trimmedDate);
    }

    /**
     * Parses a {@code String description} into a {@code Description}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code description} is invalid.
     */
    public static Description parseExpenseDescription(String description) throws ParseException {
        requireNonNull(description);
        String trimmedDescription = description.trim();
        if (!Description.isValidDescription(trimmedDescription)) {
            throw new ParseException(Description.MESSAGE_CONSTRAINTS);
        }
        return new Description(trimmedDescription);
    }

    /**
     * Parses a {@code String currency} into a {@code Currency}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code currency} is invalid.
     */
    public static Currency parseCurrency(String currency) throws ParseException {
        requireNonNull(currency);
        return new Currency(currency.trim().toUpperCase());
    }

    /**
     * Parses a {@code String budget} into a {@code Budget}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code budget} is invalid.
     */
    public static Budget parseBudget(String budget) throws ParseException {
        try {
            double value = Double.parseDouble(budget.trim());
            if (value <= 0) {
                throw new ParseException(
                    SetBudgetCommand.MESSAGE_SET_BUDGET_FAIL);
            }
            return new Budget(value);
        } catch (Exception pe) {
            throw new ParseException(
                    SetBudgetCommand.MESSAGE_SET_BUDGET_FAIL, pe);
        }
    }

    /**
     * Parses a {@code String input} into a {@code Order}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code input} is invalid.
     */
    public static Order parseOrder(String input) throws ParseException {
        String trimmedInput = input.trim();
        return new Order(trimmedInput);
    }
}
