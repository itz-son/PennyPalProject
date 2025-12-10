package pennypal.view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pennypal.AppState;
import pennypal.controller.NavigationController;
import pennypal.model.BudgetSummary;

/**
 * Spending breakdown screen where the user can adjust savings and swap months.
 */
public class BreakdownViewController {

    @FXML
    private Label monthLabel;

    @FXML
    private ComboBox<String> monthSelector;

    @FXML
    private Label incomeLabel;
    @FXML
    private Label expensesLabel;
    @FXML
    private Label leftoverLabel;
    @FXML
    private TextField savingsInputField;
    @FXML
    private Label leftAfterSavingsLabel;

    private final NavigationController navigationController = new NavigationController();
    private final AppState appState = AppState.getInstance();

    @FXML
    public void initialize() {
        BudgetSummary summary = appState.getLastSummary();
        if (summary == null) return;

        monthSelector.getItems().addAll("Oct", "Nov", "Dec");
        monthSelector.getSelectionModel().selectFirst();
        monthLabel.setText(monthSelector.getSelectionModel().getSelectedItem());

        incomeLabel.setText(format(summary.getIncome()));
        expensesLabel.setText(format(summary.getExpensesTotal()));
        leftoverLabel.setText(format(summary.getLeftoverBeforeSavings()));

        double planned = appState.getPlannedSavings();
        savingsInputField.setText(String.format("%.0f", planned));
        updateLeftAfterSavings();

        monthSelector.valueProperty().addListener((obs, oldVal, newVal) -> {
            monthLabel.setText(newVal);
        });
    }

    private String format(double value) {
        return String.format("$%,.0f", value);
    }

    private void updateLeftAfterSavings() {
        BudgetSummary summary = appState.getLastSummary();
        if (summary == null) return;

        double leftover = summary.getLeftoverBeforeSavings();
        try {
            double savings = Double.parseDouble(savingsInputField.getText().replace(",", "").trim());
            appState.setPlannedSavings(savings);
            double after = leftover - savings;
            leftAfterSavingsLabel.setText(format(after));
        } catch (NumberFormatException e) {
            leftAfterSavingsLabel.setText("—");
        }
    }

    @FXML
    private void handleAdjustSavings() {
        updateLeftAfterSavings();
    }

    @FXML
    private void handleBack() {
        navigationController.goToResults();
    }

    @FXML
    private void handleNext() {
        navigationController.goToFinal();
    }
}
