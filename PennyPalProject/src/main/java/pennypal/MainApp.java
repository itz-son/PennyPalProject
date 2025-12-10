/**
 * Main entry point for the Penny Pal application.
 *
 * Responsibilities:
 *  - Initializes the JavaFX stage and loads the first scene.
 *  - Provides a global scene-switching helper (changeScene) used by controllers.
 *  - Loads external CSV data using CsvDataLoader to demonstrate file I/O.
 *  - Stores an AppState instance shared across all screens.
 *
 * MVC Role: Application bootstrap + View navigation.
 */
package pennypal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pennypal.model.Category;
import pennypal.model.Tax;
import pennypal.service.CsvDataLoader;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MainApp extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;

        // Load shared data from CSVs on the classpath
        AppState appState = AppState.getInstance();
        List<Tax> taxes = CsvDataLoader.loadTaxRates("data/tax_rates.csv");
        List<Category> categories = CsvDataLoader.loadCategories("data/default_categories.csv");
        appState.setTaxTable(taxes);
        appState.setCategories(categories);

        Parent root = loadFXML("WelcomeView");
        Scene scene = new Scene(root, 400, 700);
        addStylesheet(scene);

        stage.setTitle("Penny Pal");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void changeScene(String fxmlName) {
        try {
            Parent root = loadFXML(fxmlName);
            Scene scene = new Scene(root, 400, 700);
            addStylesheet(scene);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Parent loadFXML(String fxmlName) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                MainApp.class.getResource("/fxml/" + fxmlName + ".fxml")
        );
        return loader.load();
    }

    private static void addStylesheet(Scene scene) {
        var cssUrl = MainApp.class.getResource("/css/pennypal.css");
        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        } else {
            System.err.println("WARNING: CSS stylesheet /css/pennypal.css not found.");
        }
    }


    public static void main(String[] args) {
        launch();
    }
}
