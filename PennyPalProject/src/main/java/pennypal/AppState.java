/**
 * AppState is the shared data model for the entire Penny Pal application.
 *
 * Responsibilities:
 *  - Store user information such as email and monthly income.
 *  - Store responsibility/expense values entered by the user.
 *  - Perform basic calculations (total expenses, leftover income, etc.).
 *  - Hold optional external CSV data (tax tables, default categories).
 *
 * MVC Role: Central Model for long-lived data across all scenes.
 */
package pennypal;

import pennypal.model.BudgetSummary;
import pennypal.model.Category;
import pennypal.model.Tax;
import pennypal.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton that tracks application-wide state like the current user
 * and shared tax/category tables.
 */
public class AppState {

    private static final AppState INSTANCE = new AppState();

    private User currentUser;
    private List<Tax> taxTable = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();

    // For passing summary data between screens
    private BudgetSummary lastSummary;
    private double plannedSavings = 0.0;

    private AppState() {
    }

    public static AppState getInstance() {
        return INSTANCE;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public List<Tax> getTaxTable() {
        return taxTable;
    }

    public void setTaxTable(List<Tax> taxTable) {
        this.taxTable = taxTable;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public BudgetSummary getLastSummary() {
        return lastSummary;
    }

    public void setLastSummary(BudgetSummary lastSummary) {
        this.lastSummary = lastSummary;
        if (lastSummary != null) {
            this.plannedSavings = lastSummary.getRecommendedSavings();
        }
    }

    public double getPlannedSavings() {
        return plannedSavings;
    }

    public void setPlannedSavings(double plannedSavings) {
        this.plannedSavings = plannedSavings;
    }
}
