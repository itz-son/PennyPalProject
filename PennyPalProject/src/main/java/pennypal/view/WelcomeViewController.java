package pennypal.view;

import javafx.fxml.FXML;
import pennypal.controller.NavigationController;

/**
 * Controller for the welcome screen.
 */
public class WelcomeViewController {

    private final NavigationController navigationController = new NavigationController();

    @FXML
    private void handleGetStarted() {
        navigationController.goToAccount();
    }
}
