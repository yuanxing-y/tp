package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.expense.Amount;
import seedu.address.model.expense.Category;
import seedu.address.model.expense.Currency;
import seedu.address.model.expense.Date;
import seedu.address.model.expense.Description;
import seedu.address.model.expense.Expense;


/**
 * Jackson-friendly version of {@link Expense}.
 */
class JsonAdaptedExpense {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Expense's %s field is missing!";
    private final String amount;
    private final String currency;
    private final String date;
    private final String category;
    private final String description;

    /**
     * Constructs a {@code JsonAdaptedExpense} with the given expense details.
     */
    @JsonCreator
    public JsonAdaptedExpense(@JsonProperty("amount") String amount, @JsonProperty("currency") String currency,
                              @JsonProperty("date") String date,
                             @JsonProperty("category") String category,
                             @JsonProperty("description") String description) {
        this.amount = amount;
        this.currency = currency;
        this.date = date;
        this.category = category;
        this.description = description;
    }

    /**
     * Converts a given {@code Expense} into this class for Jackson use.
     */
    public JsonAdaptedExpense(Expense source) {
        amount = source.getAmount().value.toString();
        currency = source.getCurrency().currencyCode;
        date = source.getDate().date;
        category = source.getCategory().categoryName;
        description = source.getDescription().value;
    }

    /**
     * Converts this Jackson-friendly adapted expense object into the model's {@code Expense} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted expense.
     */
    public Expense toModelType() throws IllegalValueException {

        if (amount == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Amount.class.getSimpleName()));
        }
        final Amount modelAmount = new Amount(Double.valueOf(amount));

        if (currency == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Currency.class.getSimpleName()));
        }
        final Currency modelCurrency = new Currency(currency);

        if (date == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Date.class.getSimpleName()));
        }
        final Date modelDate = new Date(date);

        if (category == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Category.class.getSimpleName()));
        }
        final Category modelCategory = new Category(category);

        if (description == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Description.class.getSimpleName()));
        }
        final Description modelDescription = new Description(description);

        return new Expense(modelAmount, modelCurrency, modelDate, modelCategory, modelDescription);
    }

}
