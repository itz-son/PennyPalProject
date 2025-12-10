# Penny Pal JavaFX Demo (Importable Project)

This is a minimal JavaFX + MVC Penny Pal demo project you can import directly into IntelliJ.

## How to Import in IntelliJ

1. Download and unzip this project.
2. In IntelliJ:
   - **File → New → Project from Existing Sources…**
   - Select the unzipped `PennyPalProject` folder.
   - Choose **Import project from existing sources** (or as a simple Gradle/Java project if you add your own build file).
3. Make sure your **Project SDK** is set to Java 17 (or whatever your course uses).
4. Configure JavaFX:
   - Either via a Gradle/Maven build file **or**
   - Manually add JavaFX libraries to the project and set VM options:
     `--module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml`
5. Run the `MainApp` class in the `pennypal` package.

## Flow

Welcome → Account → Responsibility Yes/No → Income → Results

The Results screen will show a basic summary and a **Back to Welcome Page** button with a confirmation popup, similar to your Figma prototype.

You can now:
- Replace the CSV files in `src/main/resources/data/` with your real ones.
- Extend the views and controllers with your full Penny Pal logic.
- Push this structure into your team GitHub repo and add your README + UML.
