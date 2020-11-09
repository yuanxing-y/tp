package seedu.address.model.expense;

import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Represents a Expense's date in the expense book.
 * Guarantees: the date is non-negative; is valid as declared in {@link #isValidDate(String)}
 */
public class Date {

    public static final String MESSAGE_CONSTRAINTS =
            "Date can be entered in one of these two ways: \n"
                   + "i) A single number to represent number of days before today."
        + "and it should be at least 1 digits long. Eg: 1 refer to 1 day  ago \n"
                    + "and it should be less than LARGEST_DAY_AGO. \n"
            + "ii) The actual date,format: YYYY-MM-DD. Eg: 2020-11-12. Note that the date can't be set "
                    + "to be in the future.";
    public static final int LARGEST_DAY_AGO = 3650;
    public final String date;
    public final String howManyDaysAgo;
    private LocalDate localDate;

    /**
     * Constructor for Date.
     * @param inputDay Allow user to type in how many days ago he spent the money.
     */
    public Date(String inputDay) {
        checkArgument(isValidDate(inputDay), MESSAGE_CONSTRAINTS);
        if (!inputDay.contains("-")) {
            this.howManyDaysAgo = inputDay;
            assert Integer.parseInt(inputDay) >= 0 && Integer.parseInt(inputDay) <= LARGEST_DAY_AGO
                    : "Invalid days Being Enter";
            LocalDate localdate = LocalDate.now();
            int convertedDay = Integer.parseInt(inputDay);
            LocalDate dayBefore = localdate.minusDays(convertedDay);
            localDate = dayBefore;
            this.date = dayBefore.toString();
        } else {
            this.howManyDaysAgo = "undefined";
            this.date = inputDay;
            localDate = LocalDate.parse(date);
        }
    }
    /**
     * Constructor for Date. When the date is not entered, localdate will be used for the date of expense。
     */
    public Date () {
        LocalDate localdate = LocalDate.now();
        this.howManyDaysAgo = "0";
        this.date = localdate.toString();
        localDate = localdate;
    }
    /**
     * Returns true if a given string is a valid Day.
     */
    public static boolean isValidDate(String test) {
        //return test.matches(VALIDATION_REGEX);
        if (test.contains("-")) {
            try {
                LocalDate today = LocalDate.now();
                LocalDate date = LocalDate.parse(test);
                if (today.isBefore(date)) {
                    return false;
                }
                return true;
            } catch (DateTimeParseException e) {
                return false;
            }
        } else {
            try {
                int dayBefore = Integer.parseInt(test);
                return dayBefore >= 0 && dayBefore <= LARGEST_DAY_AGO;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

    /**
     * Gets the localDate of the Date.
     *
     * @return The localDate of the date.
     */
    public LocalDate getLocalDate() {
        return this.localDate;
    }

    @Override
    public String toString() {
        return this.date;
    }

    @Override
    public int hashCode() {
        return this.date.hashCode();
    }

    public String getDate() {
        return this.date;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Date // instanceof handles nulls
                && date.equals(((Date) other).date)); // state check
    }

}
