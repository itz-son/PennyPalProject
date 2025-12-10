package pennypal.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pennypal.AppState;
import pennypal.controller.NavigationController;
import pennypal.model.Expense;
import pennypal.model.User;

/**
 * Lets the user enter monthly amounts for key responsibilities.
 */
public class ResponsibilitiesViewController {

    @FXML
    private TextField rentField;
    @FXML
    private TextField utilitiesField;
    @FXML
    private TextField insuranceField;
    @FXML
    private TextField studentLoanField;
    @FXML
    private TextField transportationField;
    @FXML
    private TextField otherField;
    @FXML
    private Label errorLabel;

    private final NavigationController navigationController = new NavigationController();

    @FXML
    private void handleBack() {
        navigationController.goToAccount();
    }

    @FXML
    private void handleNext() {
        User user = AppState.getInstance().getCurrentUser();
        if (user == null) {
            errorLabel.setText("No user found. Please go back and create an account.");
            return;
        }

        // Clear any previous responsibilities
        user.getResponsibilities().clear();

        try {
            addIfPresent(user, "Rent", rentField.getText());
            addIfPresent(user, "Utilities", utilitiesField.getText());
            addIfPresent(user, "Insurance", insuranceField.getText());
            addIfPresent(user, "Student Loan", studentLoanField.getText());
            addIfPresent(user, "Transportation", transportationField.getText());
            addIfPresent(user, "Other", otherField.getText());

            errorLabel.setText("");
            navigationController.goToIncome();
        } catch (NumberFormatException e) {
            errorLabel.setText("Please enter valid numbers (or leave fields blank).");
        }
    }

    private void addIfPresent(User user, String name, String text) {
        if (text == null || text.isBlank()) return;
        double amount = Double.parseDouble(text.replace(",", "").trim());
        if (amount <= 0) return;
        user.addExpense(new Expense(name, amount, name));
    }
}
