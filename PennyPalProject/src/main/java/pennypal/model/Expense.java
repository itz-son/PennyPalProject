package pennypal.model;

/**
 * Represents a single expense/responsibility.
 */
public class Expense {

    private String name;
    private double amount;
    private String category;

    public Expense(String name, double amount, String category) {
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public void updateAmount(double newAmount) {
        this.amount = newAmount;
    }

    public String getCategory() {
        return category;
    }
}
