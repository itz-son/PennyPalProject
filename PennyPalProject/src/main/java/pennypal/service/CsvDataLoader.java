package pennypal.service;

import pennypal.model.Category;
import pennypal.model.Tax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for loading CSV data from the classpath.
 *
 * For this project, the main goal is to demonstrate file I/O:
 * - We load CSV files from src/main/resources/data
 * - We read through the contents
 * - We return lists so the rest of the app can hold a "tax table" and
 *   "default categories", even though the UI does not yet use them directly.
 */
public class CsvDataLoader {

    /**
     * Loads tax rate data from a CSV on the classpath.
     *
     * @param resourcePath path like "data/tax_rates.csv"
     * @return list of Tax objects (currently empty – data not used in UI)
     * @throws IOException if the resource cannot be found or read
     */
    public static List<Tax> loadTaxRates(String resourcePath) throws IOException {
        List<Tax> taxes = new ArrayList<>();

        try (BufferedReader reader = openResource(resourcePath)) {
            String line;

            // Example: read and discard header
            // (In a full implementation we'd parse columns into Tax objects.)
            reader.readLine();

            // Read the rest of the file line by line
            while ((line = reader.readLine()) != null) {
                // Parsing could go here.
                // For now we just demonstrate reading the file.
            }
        }

        return taxes;
    }

    /**
     * Loads default category data from a CSV on the classpath.
     *
     * @param resourcePath path like "data/default_categories.csv"
     * @return list of Category objects (currently empty – data not used in UI)
     * @throws IOException if the resource cannot be found or read
     */
    public static List<Category> loadCategories(String resourcePath) throws IOException {
        List<Category> categories = new ArrayList<>();

        try (BufferedReader reader = openResource(resourcePath)) {
            String line;

            // Example: read and discard header
            reader.readLine();

            // Read the rest of the file
            while ((line = reader.readLine()) != null) {
                // Parsing could go here.
                // For now we just demonstrate reading the file.
            }
        }

        return categories;
    }

    /**
     * Helper to open a resource from the classpath and wrap it in a BufferedReader.
     *
     * @param resourcePath path relative to classpath root, e.g. "data/tax_rates.csv"
     * @return BufferedReader for the resource
     * @throws IOException if the resource is not found
     */
    private static BufferedReader openResource(String resourcePath) throws IOException {
        // We expect resourcePath like "data/tax_rates.csv"
        InputStream in = CsvDataLoader.class.getResourceAsStream("/" + resourcePath);
        if (in == null) {
            throw new IOException("Resource not found: " + resourcePath);
        }
        return new BufferedReader(new InputStreamReader(in));
    }
}
