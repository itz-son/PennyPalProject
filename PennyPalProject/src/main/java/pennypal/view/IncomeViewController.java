package pennypal.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pennypal.AppState;
import pennypal.controller.NavigationController;
import pennypal.model.User;

/**
 * Controller for the income input screen.
 */
public class IncomeViewController {

    @FXML
    private TextField incomeField;

    @FXML
    private Label errorLabel;

    private final NavigationController navigationController = new NavigationController();

    @FXML
    private void handleNext() {
        try {
            double income = Double.parseDouble(incomeField.getText().replace(",", "").trim());
            User user = AppState.getInstance().getCurrentUser();
            if (user != null) {
                user.setMonthlyIncome(income);
            }
            errorLabel.setText("");
            navigationController.goToResults();
        } catch (NumberFormatException e) {
            errorLabel.setText("Please enter a valid number for income.");
        }
    }

    @FXML
    private void handleBack() {
        navigationController.goToResponsibilities();
    }
}
