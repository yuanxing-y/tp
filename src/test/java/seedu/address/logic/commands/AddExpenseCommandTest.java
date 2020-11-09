package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.ExpenseBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyExpenseBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.expense.Budget;
import seedu.address.model.expense.Category;
import seedu.address.model.expense.Currency;
import seedu.address.model.expense.ExchangeRate;
import seedu.address.model.expense.Expense;
import seedu.address.testutil.ExpenseBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddExpenseCommand}.
 */
public class AddExpenseCommandTest {

    @Test
    public void constructor_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddExpenseCommand(null));
    }

    @Test
    public void execute_expenseAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingExpenseAdded modelStub = new ModelStubAcceptingExpenseAdded();
        Expense validExpense = new ExpenseBuilder().build();

        CommandResult commandResult = new AddExpenseCommand(validExpense).execute(modelStub);

        assertEquals(String.format(AddExpenseCommand.MESSAGE_SUCCESS, validExpense), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validExpense), modelStub.expensesAdded);
    }
    @Test
    public void equals() {
        ExpenseBuilder aliceAmountAndCategory = new ExpenseBuilder().withAmount(20.0).withCategory("Entertainment");
        Expense alice = aliceAmountAndCategory.withDate("1").withDescription("movie").build();
        ExpenseBuilder bobWithAmount = new ExpenseBuilder().withAmount(50.0);
        ExpenseBuilder bobAmountAndCategory = bobWithAmount.withAmount(50.0).withCategory("Entertainment");
        Expense bob = bobAmountAndCategory.withDate("2").withDescription("hotpot").build();
        AddExpenseCommand addAliceExpenseCommand = new AddExpenseCommand(alice);
        AddExpenseCommand addBobExpenseCommand = new AddExpenseCommand(bob);

        // same object -> returns true
        assertTrue(addAliceExpenseCommand.equals(addAliceExpenseCommand));

        // same values -> returns true
        AddExpenseCommand addAliceExpenseCommandCopy = new AddExpenseCommand(alice);
        assertTrue(addAliceExpenseCommand.equals(addAliceExpenseCommandCopy));

        // different types -> returns false
        assertFalse(addAliceExpenseCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceExpenseCommand.equals(null));

        // different expenses -> returns false
        assertFalse(addAliceExpenseCommand.equals(addBobExpenseCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getExpenseBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setExpenseBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addExpense(Expense expense) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setExpenseBook(ReadOnlyExpenseBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyExpenseBook getExpenseBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasExpense(Expense expense) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteExpense(Expense target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setExpense(Expense target, Expense editedExpense) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Expense> getFilteredExpenseList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredExpenseList(Predicate<Expense> predicate) {
            throw new AssertionError("This method should not be called.");
        }
        @Override
        public ReadOnlyExpenseBook getExpenseBookWithoutSample() {
            return null;
        }
        @Override
        public Budget getExpenseBookBudget() {
            return null;
        }

        @Override
        public Budget getExpenseBookRemaining() {
            return null;
        }

        @Override
        public void setExpenseBookBudget(Budget budget) {
        }

        @Override
        public void setExpenseBookCurrency(Currency dollarSign) {
        }

        @Override
        public void expenseBookExchange(ExchangeRate exchangeRate) {
        }

        @Override
        public Currency getExpenseBookCurrency() {
            return null;
        }

        @Override
        public List<Category> getCategoryLabels() {
            return null;
        }

        @Override
        public int getExpenseSumByCategory(String categoryName) {
            return -1;
        }

        @Override
        public int getTotalExpense() {
            return -1;
        }

        @Override
        public double getExpenseSum() {
            return -1.0;
        }

        @Override
        public HashMap<String, Double> getExpenseSumCategory() {
            return null;
        }

        @Override
        public HashMap<String, Double> getExpensePercentageCategory() {
            return null;
        }

        @Override
        public double getExpenseSumOfCategory(String categoryName) {
            return -1.0;
        }

        @Override
        public void sortByDescendingAmount() {
        }

        @Override
        public void sortByAscendingAmount() {
        }

        @Override
        public void sortByDescendingTime() {
        }

        @Override
        public void sortByAscendingTime() {
        }
        @Override
        public double getExpenseBookSpending() {
            return -1.0;
        }
    }

    /**
     * A Model stub that contains a single person.
     */
    private class ModelStubWithExpense extends ModelStub {
        private final Expense expense;

        ModelStubWithExpense(Expense expense) {
            requireNonNull(expense);
            this.expense = expense;
        }

        @Override
        public boolean hasExpense(Expense expense) {
            requireNonNull(expense);
            return this.expense.isSameExpense(expense);
        }
    }

    /**
     * A Model stub that always accept the person being added.
     */
    private class ModelStubAcceptingExpenseAdded extends ModelStub {
        final ArrayList<Expense> expensesAdded = new ArrayList<>();

        @Override
        public boolean hasExpense(Expense expense) {
            requireNonNull(expense);
            return expensesAdded.stream().anyMatch(expense::isSameExpense);
        }

        @Override
        public void addExpense(Expense expense) {
            requireNonNull(expense);
            expensesAdded.add(expense);
        }

        @Override
        public ReadOnlyExpenseBook getExpenseBook() {
            return new ExpenseBook();
        }
    }
}
