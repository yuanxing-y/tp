package seedu.address.model.expense;

public class StatisticSummary {

    private final String category;
    private final int numberOfExpense;
    private final String percentage;
    private final String totalSpending;
    protected StatisticSummary(String category, int numberOfExpense, String percentage, String totalSpending) {
        this.category = category;
        this.numberOfExpense = numberOfExpense;
        this.percentage = percentage;
        this.totalSpending = totalSpending;
    }
    public String getCategory() {
        return this.category;
    }
    public int getNumberOfExpense() {
        return this.numberOfExpense;
    }
    public String getPercentage() {
        return this.percentage;
    }
    public String getTotalSpending() {
        return this.totalSpending;
    }
}
