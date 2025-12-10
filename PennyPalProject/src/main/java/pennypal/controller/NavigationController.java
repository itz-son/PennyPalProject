package pennypal.controller;

import pennypal.MainApp;

/**
 * Handles navigation between scenes.
 */
public class NavigationController {

    public void goToWelcome() {
        MainApp.changeScene("WelcomeView");
    }

    public void goToAccount() {
        MainApp.changeScene("AccountView");
    }

    public void goToResponsibilities() {
        MainApp.changeScene("ResponsibilitiesView");
    }

    public void goToIncome() {
        MainApp.changeScene("IncomeView");
    }

    public void goToResults() {
        MainApp.changeScene("ResultsView"); // summary screen
    }

    public void goToBreakdown() {
        MainApp.changeScene("BreakdownView");
    }

    public void goToFinal() {
        MainApp.changeScene("FinalView");
    }
}
