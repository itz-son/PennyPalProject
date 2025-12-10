package pennypal.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pennypal.AppState;
import pennypal.controller.BudgetController;
import pennypal.controller.NavigationController;
import pennypal.model.BudgetSummary;
import pennypal.model.Expense;
import pennypal.model.User;

/**
 * Summary screen showing income, each responsibility, and remainder.
 */
public class ResultsViewController {

    @FXML
    private Label incomeValueLabel;
    @FXML
    private Label rentValueLabel;
    @FXML
    private Label utilitiesValueLabel;
    @FXML
    private Label insuranceValueLabel;
    @FXML
    private Label studentLoanValueLabel;
    @FXML
    private Label transportationValueLabel;
    @FXML
    private Label remainderValueLabel;

    private final BudgetController budgetController = new BudgetController();
    private final NavigationController navigationController = new NavigationController();

    @FXML
    public void initialize() {
        User user = AppState.getInstance().getCurrentUser();
        if (user == null) return;

        BudgetSummary summary = budgetController.computeAllocations(user);
        AppState.getInstance().setLastSummary(summary);

        incomeValueLabel.setText(format(summary.getIncome()));

        double rent = getAmount(user, "Rent");
        double utilities = getAmount(user, "Utilities");
        double insurance = getAmount(user, "Insurance");
        double student = getAmount(user, "Student Loan");
        double transportation = getAmount(user, "Transportation");

        rentValueLabel.setText(format(rent));
        utilitiesValueLabel.setText(format(utilities));
        insuranceValueLabel.setText(format(insurance));
        studentLoanValueLabel.setText(format(student));
        transportationValueLabel.setText(format(transportation));

        double remainder = summary.getLeftoverBeforeSavings();
        remainderValueLabel.setText(format(remainder));
    }

    private double getAmount(User user, String categoryName) {
        return user.getResponsibilities().stream()
                .filter(e -> categoryName.equalsIgnoreCase(e.getName()))
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    private String format(double value) {
        return String.format("$%,.0f", value);
    }

    @FXML
    private void handleNext() {
        navigationController.goToBreakdown();
    }

    @FXML
    private void handleBack() {
        navigationController.goToIncome();
    }
}
