package pennypal.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import pennypal.AppState;
import pennypal.controller.AccountController;
import pennypal.controller.NavigationController;
import pennypal.model.User;

/**
 * Controller for the account creation/login screen.
 */
public class AccountViewController {

    @FXML
    private TextField emailField;

    private final AccountController accountController = new AccountController();
    private final NavigationController navigationController = new NavigationController();

    @FXML
    private void handleBack() {
        navigationController.goToWelcome();
    }

    @FXML
    private void handleContinue() {
        String email = emailField.getText();
        if (email == null || email.isBlank()) {
            showInfo("Missing email", "Please enter an email address to continue.");
            return;
        }

        User user = accountController.createAccount(email, "Penny Pal User");
        AppState.getInstance().setCurrentUser(user);

        navigationController.goToResponsibilities();
    }

    @FXML
    private void handleGoogleLogin() {
        showInfo("Continue with Google",
                "In a full version, this would open Google sign-in.\nFor now, it's a placeholder.");
    }

    @FXML
    private void handleAppleLogin() {
        showInfo("Continue with Apple",
                "In a full version, this would open Apple sign-in.\nFor now, it's a placeholder.");
    }

    private void showInfo(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
