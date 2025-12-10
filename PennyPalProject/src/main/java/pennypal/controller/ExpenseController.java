package pennypal.controller;

import pennypal.model.Expense;
import pennypal.model.User;

/**
 * Manages user expenses/responsibilities.
 */
public class ExpenseController {

    public void addExpense(User user, Expense expense) {
        user.addExpense(expense);
    }

    public void updateExpense(User user, Expense expense, double newAmount) {
        expense.updateAmount(newAmount);
    }
}
