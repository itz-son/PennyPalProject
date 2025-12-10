# 🪙 Penny Pal
### Smart Monthly Budgeting Assistant (JavaFX • MVC • CSV File I/O)

Penny Pal is a modern budgeting application designed to help users understand their monthly income, responsibilities, expenses, and savings goals through a simple guided workflow.  
The app walks the user step-by-step, calculates leftover income, and produces a breakdown screen similar to a financial dashboard.

This version of the project was completed as part of a semester-long JavaFX MVC application assignment.

---

## 📌 Features

### ✔ Multi-Screen Guided Flow
- Welcome screen  
- Account creation (email)  
- Responsibility input  
- Monthly income input  
- Budget summary screen  
- Spending breakdown (with savings adjustment)  
- Final screen with option to restart  

### ✔ Clean MVC Architecture
- **Model:** User data, expenses, calculations  
- **View:** FXML files styled with CSS  
- **Controller:** Handles navigation and screen logic  

### ✔ JavaFX UI
- Custom gradient UI theme  
- Rounded cards, buttons, and input fields  
- Responsive layout sized to mimic a mobile app  
- Styled with `pennypal.css`

### ✔ File I/O (CSV)
The app loads external data from:  
- `data/tax_rates.csv`  
- `data/default_categories.csv`  
- `data/sample_users.csv`  

Using the included `CsvDataLoader` class, which demonstrates reading resource files through the classpath.

### ✔ Fully Functional Navigation
Buttons navigate between screens using the `MainApp.changeScene()` method.

---

## 📂 Project Structure

```
src/main/
├── java/pennypal/
│   ├── controller/          # All screen controllers
│   ├── model/               # AppState, User, Expense models
│   ├── service/             # CsvDataLoader (file I/O)
│   ├── view/                # Navigation helpers
│   ├── MainApp.java         # App entry point
│   └── AppState.java        # Stores global application data
│
└── resources/
    ├── fxml/                # All UI screens
    │   ├── WelcomeView.fxml
    │   ├── AccountView.fxml
    │   ├── ResponsibilitiesView.fxml
    │   ├── IncomeView.fxml
    │   ├── ResultsView.fxml
    │   ├── BreakdownView.fxml
    │   └── FinalView.fxml
    │
    ├── css/
    │   └── pennypal.css     # UI stylesheet
    │
    └── data/
        ├── tax_rates.csv
        ├── default_categories.csv
        └── sample_users.csv
```

---

# ▶ How to Run the Application

### **Requirements**
- **Java 17+** (Java 21 or 22 recommended)
- **JavaFX SDK** (Your instructor likely already provided instructions)
- IntelliJ IDEA recommended

### **VM Options (Required to run JavaFX)**  
Go to **Run → Edit Configurations → VM Options** and paste:

```
--module-path "YOUR_JAVAFX_SDK_PATH/lib" --add-modules javafx.controls,javafx.fxml
```

Example:

```
--module-path "C:\javafx-sdk-24\lib" --add-modules javafx.controls,javafx.fxml
```

---

## 🚀 Running the App

1. Open the project folder in IntelliJ  
2. Mark `src/main/resources` as **Resources Root**  
3. In the project panel, open `MainApp.java`  
4. Click **Run → Run MainApp**  

The app should open with the full styled interface.

---

# 🛠 Known Issues

- This version does not currently store user data between runs.  
- CSV file contents are read (to satisfy I/O requirements), but are not used in on-screen calculations.  
- Window resizing is not restricted; UI is best viewed at the default size.

---

# 👨‍💻 Contributors

| Name |
|------|
| Hudson Borden |
| Angela Paral |
| Naman Patel |

---

# 📐 UML Diagram

Include your diagram file here once exported (e.g., from draw.io):  
`docs/penny_pal_uml.png`

---

# 📄 License

This project was created for academic purposes only.
