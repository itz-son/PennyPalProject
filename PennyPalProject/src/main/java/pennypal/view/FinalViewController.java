package pennypal.view;

import javafx.fxml.FXML;
import pennypal.controller.NavigationController;

/**
 * Final screen thanking the user and offering Back to Welcome.
 */
public class FinalViewController {

    private final NavigationController navigationController = new NavigationController();

    @FXML
    private void handleBackToWelcome() {
        navigationController.goToWelcome();
    }
}
