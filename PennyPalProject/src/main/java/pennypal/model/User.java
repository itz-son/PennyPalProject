package pennypal.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Penny Pal user and their income/expenses.
 */
public class User {

    private String userId;
    private String name;
    private String email;
    private double monthlyIncome;
    private final List<Expense> responsibilities = new ArrayList<>();

    public User(String userId, String name, String email, double monthlyIncome) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.monthlyIncome = monthlyIncome;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public List<Expense> getResponsibilities() {
        return responsibilities;
    }

    public void addExpense(Expense expense) {
        responsibilities.add(expense);
    }

    public double getExpenseTotal() {
        return responsibilities.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public double calculateAvailableFunds() {
        return monthlyIncome - getExpenseTotal();
    }

    public String toCSVRow() {
        return userId + "," + name + "," + email + "," + monthlyIncome;
    }
}
