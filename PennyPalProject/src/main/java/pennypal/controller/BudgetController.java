package pennypal.controller;

import pennypal.AppState;
import pennypal.model.BudgetSummary;
import pennypal.model.User;

/**
 * Computes the BudgetSummary based on the current user.
 */
public class BudgetController {

    private final AppState appState = AppState.getInstance();

    public BudgetSummary computeAllocations(User user) {
        double income = user.getMonthlyIncome();
        double expenses = user.getExpenseTotal();

        // Simple rule: recommend 20% of income for savings
        double savingsGoal = income * 0.20;
        double recommendedSavings = savingsGoal;

        return new BudgetSummary(income, expenses, savingsGoal, recommendedSavings);
    }
}
