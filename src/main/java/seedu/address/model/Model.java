package seedu.address.model;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.expense.Budget;
import seedu.address.model.expense.Category;
import seedu.address.model.expense.Currency;
import seedu.address.model.expense.ExchangeRate;
import seedu.address.model.expense.Expense;

/**
 * The API of the Model component.
 */
public interface Model {

    Predicate<Expense> PREDICATE_SHOW_ALL_EXPENSES = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getExpenseBookFilePath();

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setExpenseBook(ReadOnlyExpenseBook expenseBook);

    /** Returns the AddressBook */
    ReadOnlyExpenseBook getExpenseBook();

    /** Returns the with sample removed */
    ReadOnlyExpenseBook getExpenseBookWithoutSample();

    /**
     * Sets the user prefs' address book file path.
     */
    void setExpenseBookFilePath(Path expenseBookFilePath);

    /**
     * Returns true if the expense exists in the address book.
     */
    boolean hasExpense(Expense expense);

    /**
     * Deletes the given Expense.
     * The Expense must exist in the address book.
     */
    void deleteExpense(Expense targetExpense);
    /**
     * Adds the given expense.
     * {@code person} must not already exist in the address book.
     */
    void addExpense(Expense expense);

    /**
     * Replaces the given expense {@code target} with {@code editedExpense}.
     * {@code target} must exist in the finance manager.
     * The person identity of {@code editedExpense} must not be the same as another existing expense in the finance
     * manager.
     */
    void setExpense(Expense target, Expense editedExpense);


    /** Returns an unmodifiable view of the filtered Expense list */
    ObservableList<Expense> getFilteredExpenseList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredExpenseList(Predicate<Expense> predicate);

    /**
     * @return Budget of the ExpenseBook.
     */
    Budget getExpenseBookBudget();

    /**
     * @return Remaining budget of the ExpenseBook.
     */
    Budget getExpenseBookRemaining();

    /**
     * @return Total spending of the ExpenseBook.
     */
    double getExpenseBookSpending();

    /**
     * Exchange all the expenses of the ExpenseBook at the given ExchangeRate.
     * @param exchangeRate of a currency.
     */
    void expenseBookExchange(ExchangeRate exchangeRate);

    /**
     * Set the budget of the ExpenseBook.
     * @param budget
     */
    void setExpenseBookBudget(Budget budget);

    /**
     * @return the currency of the ExpenseBook.
     */
    Currency getExpenseBookCurrency();

    /**
     * Set the currency of the ExpenseBook into the given currency code.
     * @param code of the currency.
     */
    void setExpenseBookCurrency(Currency code);

    /**
     * Get the total spending of all the categories.
     * @return a hashmap that contains the total spending of all all categories.
     */
    List<Category> getCategoryLabels();
    /**
     * Get the total spending of the specific category.
     * @param categoryName the total spending of the specific category.
     * @return the total spending of that specific category.
     */
    int getExpenseSumByCategory(String categoryName);

    /**
     * Get the total number of expenses in the expense book.
     */
    int getTotalExpense();

    /**
     * Sorts the expense list by descending amount.
     */
    void sortByDescendingAmount();

    /**
     * Sorts the expense list by ascending amount.
     */
    void sortByAscendingAmount();

    /**
     * Sorts the expense list by descending timr.
     */
    void sortByDescendingTime();

    /**
     * Sorts the expense list by ascending time.
     */
    void sortByAscendingTime();

    /**
     * Get the total spending of the expenses in the expense book.
     */
    double getExpenseSum();
    /**
     * Get the total spending of all the categories.
     * @return a hashmap that contains the total spending of all all categories.
     */
    HashMap<String, Double> getExpenseSumCategory();
    /**
     * Get the percentage of different categories' spending.
     * @return a hashmap that contains the percentage of different categories' spending.
     */
    HashMap<String, Double> getExpensePercentageCategory();
    /**
     * Get the total number of expenses of the specific category.
     * @param categoryName the total number of expenses of the specific category.
     * @return the total number of expenses of that specific category.
     */
    double getExpenseSumOfCategory(String categoryName);

}
