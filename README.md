# Selenium Test Suite

## Overview
This repository contains a set of automated tests written using Selenium WebDriver with TestNG. The test suite covers various UI interactions and validations for web elements, including form filling, checkboxes, and file handling from Excel.

The following tests have been implemented:
1. **Text Box Form Test**: Fills out a text box form using data from an Excel file and validates the submitted results.
2. **Check Box Test**: Selects a checkbox and verifies the expected output.
3. **Visibility Check Test**: Ensures that web elements, including buttons, are visible and interactable before performing actions.
4. **Date Reading Test**: Reads data from an Excel file and interacts with web elements accordingly.

## Prerequisites
- Java Development Kit (JDK) 1.8 or higher
- [Maven](https://maven.apache.org/) for project build and dependency management
- A web browser (e.g., Chrome, Firefox)
- A compatible WebDriver (e.g., `chromedriver` for Chrome, `geckodriver` for Firefox)
- TestNG for running the test suite

## Setup Instructions

1. Clone this repository:
    ```bash
    git clone https://github.com/your-repo-name.git
    ```

2. Navigate to the project directory:
    ```bash
    cd your-repo-name
    ```

3. Install the dependencies using Maven:
    ```bash
    mvn clean install
    ```

4. Ensure you have the appropriate WebDriver binary in your system's `PATH` or place it in the project folder and specify the location in the test setup.

5. Create the `data.xlsx` file in the `Data` directory, with the required sheet for input data if running tests that involve Excel (such as the Text Box Test).

## Running the Tests

### Running All Tests
To run all the tests in the suite, use the following Maven command:
```bash
mvn test
```

### Running Specific Test Class
To run an individual test class, specify the class name:
```bash
mvn -Dtest=CheckBoxTest test
```

## Test Details


### 4. **Date Reading Test**
This test reads dates from an Excel file and performs actions based on those dates.

- **Test class**: `DateTest.java`
- **Key methods**:
    - `readDateFromExcel(String filePath, int sheetIndex, int rowIndex)`
    - `performDateBasedAction()`

## Project Structure

```
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── pages
│   │   │   ├── utils
│   ├── test
│   │   ├── java
│   │   │   ├── tests
│   │   │   ├── data
├── pom.xml
└── README.md
```

- `src/main/java/pages`: Page Object classes for different pages (e.g., `TextBoxPage`, `CheckBoxPage`).
- `src/test/java/tests`: Test classes for each Selenium test scenario.
- `src/test/java/data`: Excel data and other test-related input files.
- `pom.xml`: Maven dependencies and project configuration.

## Dependencies
The project uses the following libraries:
- **Selenium WebDriver**: For browser automation
- **TestNG**: For running tests
- **Apache POI**: For reading Excel files
- **WebDriverManager**: To manage WebDriver binaries automatically

## How to Contribute
If you want to contribute to this project:
1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add your feature'`).
4. Push the branch (`git push origin feature/your-feature`).
5. Open a Pull Request.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Feel free to adjust the README file to better suit your specific project structure, as needed!