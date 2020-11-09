package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.HashMap;
import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.expense.Budget;
import seedu.address.model.expense.Category;
import seedu.address.model.expense.Currency;
import seedu.address.model.expense.ExchangeRate;
import seedu.address.model.expense.Expense;
import seedu.address.model.expense.ExpenseList;
import seedu.address.model.expense.StatisticSummary;
import seedu.address.model.expense.Statistics;


/**
 * Wraps all data at the UniSave level
 * Duplicates are not allowed (by .isSameExpense comparison)
 */
public class ExpenseBook implements ReadOnlyExpenseBook {
    private static Currency currency = new Currency();
    private final ExpenseList expenses;
    private Budget budget = new Budget();


    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        expenses = new ExpenseList();
    }

    /**
     * The new ExpenseBook with budget 0 and default Currency SGD.
     */
    public ExpenseBook() {
    }

    /**
     * Creates an ExpenseBook using the Expenses in the {@code toBeCopied}
     */
    public ExpenseBook(ReadOnlyExpenseBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    public static Currency currency() {
        return ExpenseBook.currency;
    }
    //// list overwrite operations

    /**
     * Replaces the contents of the expense list with {@code expenses}.
     */
    public void setExpenses(List<Expense> expenses) {
        this.expenses.setExpenses(expenses);
    }

    /**
     * Set the currency of this {@code ExpenseBook}.
     * @param dollarSign of the currency, recommend in the format of three capital letters (e.g. CNY).
     */
    public void setCurrency(Currency dollarSign) {
        this.currency = dollarSign;
    }

    @Override
    public Currency getCurrency() {
        return this.currency;
    }

    /**
     * Exchange the {@code expenses} to the input currency.
     * @param exchangeRate from the current currency.
     */
    public void exchange(ExchangeRate exchangeRate) {
        this.budget = this.budget.exchange(exchangeRate);
        this.expenses.exchange(this.currency, exchangeRate);
    }

    /**
     * Resets the existing data of this {@code ExpenseBook} with {@code newData}.
     */
    public void resetData(ReadOnlyExpenseBook newData) {
        requireNonNull(newData);

        setExpenses(newData.getExpenseList());
        setBudget(newData.getBudget());
        setCurrency(newData.getCurrency());
    }
    //// expense-level operations

    /**
     * Returns true if a expense with the same identity as {@code expense} exists in the expense book.
     */
    public boolean hasExpense(Expense expense) {
        requireNonNull(expense);
        return expenses.contains(expense);
    }

    /**
     * Adds a expense to the expense book.
     * The expense must not already exist in the expense book.
     */
    public void addExpense(Expense p) {
        expenses.add(p);
    }

    /**
     * Replaces the given expense {@code target} in the list with {@code editedExpense}.
     * {@code target} must exist in the expense book.
     */
    public void setExpense(Expense target, Expense editedExpense) {
        requireNonNull(editedExpense);
        expenses.setExpense(target, editedExpense);
    }

    /**
     * Removes {@code key} from this {@code ExpenseBook}.
     * {@code key} must exist in the expense book.
     */
    public void removeExpense(Expense key) {
        expenses.remove(key);
    }

    /**
     * Set the budget of this {@code ExpenseBook} to the input amount.
     * @param budget Total budget.
     */
    @Override
    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    @Override
    public Budget getBudget() {
        return this.budget;
    }

    @Override
    public double totalSpending() {
        return expenses.totalSpending();
    }

    @Override
    public Budget getRemainingBudget() {
        return this.budget.remaining(expenses.totalSpending());
    }

    public List<Category> getCategoryLabels() {
        return expenses.getCategoryLabels();
    }

    public int getExpenseSumByCategory(String categoryName) {
        return expenses.getExpenseSumByCategory(categoryName);
    }

    public int getTotalExpense() {
        return expenses.getTotalExpense();
    }

    public double getExpenseSum() {
        return expenses.getExpenseSum();
    }

    public HashMap<String, Double> getExpenseSumCategory() {
        return expenses.getExpenseSumCategory();
    }

    public HashMap<String, Double> getExpensePercentageCategory() {
        return expenses.getExpensePercentageCategory();
    }

    public double getExpenseSumOfCategory(String categoryName) {
        return expenses.getExpenseSumOfCategory(categoryName);
    }

    public void sortByDescendingAmount() {
        expenses.sortByDescendingAmount();
    }

    public void sortByAscendingAmount() {
        expenses.sortByAscendingAmount();
    }

    public void sortByDescendingTime() {
        expenses.sortByDescendingTime();
    }

    public void sortByAscendingTime() {
        expenses.sortByAscendingTime();
    }

    //// util methods

    @Override
    public String toString() {
        return expenses.asUnmodifiableObservableList().size() + " expenses";
        // TODO: refine later
    }

    @Override
    public ObservableList<Expense> getExpenseList() {
        return expenses.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ExpenseBook // instanceof handles nulls
                && expenses.equals(((ExpenseBook) other).expenses));
    }

    @Override
    public int hashCode() {
        return expenses.hashCode();
    }

    public Statistics getStatistics() {
        return expenses.getStatistics();
    }

    public List<StatisticSummary> getStatisticTable() {
        return expenses.getStatisticTable();
    }

    @Override
    public void updateStatistics() {
        expenses.updateStatistics();
    }

    @Override
    public void updateStatisticSummary() {
        expenses.updateStatisticSummary();
    }

}
