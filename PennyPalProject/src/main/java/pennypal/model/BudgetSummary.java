package pennypal.model;

/**
 * Holds the final budget summary for a user.
 */
public class BudgetSummary {

    private double income;
    private double expensesTotal;
    private double savingsGoal;
    private double recommendedSavings;

    public BudgetSummary(double income, double expensesTotal,
                         double savingsGoal, double recommendedSavings) {
        this.income = income;
        this.expensesTotal = expensesTotal;
        this.savingsGoal = savingsGoal;
        this.recommendedSavings = recommendedSavings;
    }

    public double getIncome() {
        return income;
    }

    public double getExpensesTotal() {
        return expensesTotal;
    }

    public double getSavingsGoal() {
        return savingsGoal;
    }

    public double getRecommendedSavings() {
        return recommendedSavings;
    }

    /** Leftover before savings are taken out. */
    public double getLeftoverBeforeSavings() {
        return income - expensesTotal;
    }

    /** Left after both expenses and recommended savings. */
    public double calculateRemainingFunds() {
        return income - expensesTotal - recommendedSavings;
    }

    public String generateReport() {
        return "Income: " + income +
                "\nExpenses: " + expensesTotal +
                "\nLeftover (before savings): " + getLeftoverBeforeSavings() +
                "\nRecommended Savings: " + recommendedSavings +
                "\nLeft after savings: " + calculateRemainingFunds();
    }
}
