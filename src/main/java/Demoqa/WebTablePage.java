package Demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class WebTablePage {
    private WebDriver driver;

    // Constructor
    public WebTablePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By addNewRecordButton = By.id("addNewRecordButton");
    private By searchBox = By.id("searchBox");
    private By tableRow = By.cssSelector(".rt-tbody .rt-tr");
    private By tableRows = By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']"); // Updated
    private By tableCells = By.cssSelector(".rt-td"); // Changed to a simpler CSS selector
    private By editButtons = By.cssSelector("[id^='edit-record-']");
    private By deleteButtons = By.cssSelector("[id^='delete-record-']");
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("userEmail");
    private By ageField = By.id("age");
    private By salaryField = By.id("salary");
    private By departmentField = By.id("department");
    private By submitButton = By.id("submit");

    // Methods to interact with the elements
    public void clickAddNewRecord() {
        driver.findElement(addNewRecordButton).click();
    }

    public WebElement searchBox(){
        return driver.findElement(searchBox);
    }

    public void search(String query) {
        WebElement searchField = driver.findElement(searchBox);
        searchField.clear();
        searchField.sendKeys(query);
    }

    public List<WebElement> getTableRows() {
        return driver.findElements(tableRow);
    }

    public int getRowCount() {
        return driver.findElements(tableRows).size(); // Simplified this method
    }

    // Method to get the cell value at a specific row and column
    public String getCellValue(int row, int column) {
        List<WebElement> rows = driver.findElements(tableRows);
        if (row >= 0 && row < rows.size()) {
            List<WebElement> cells = rows.get(row).findElements(tableCells);
            if (column >= 0 && column < cells.size()) {
                return cells.get(column).getText(); // Return the text of the specified cell
            }
        }
        return null; // Return null if row or column is out of bounds
    }

    public String getCellData(WebElement row, int columnIndex) {
        return row.findElements(tableCells).get(columnIndex).getText();
    }

    public void editRecord(int index) {
        driver.findElements(editButtons).get(index).click();
    }

    public void deleteRecord(int index) {
        driver.findElements(deleteButtons).get(index).click();
    }

    // Methods to interact with the form fields
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).clear(); // Clear field before entering new value
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).clear(); // Clear field before entering new value
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).clear(); // Clear field before entering new value
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterAge(String age) {
        driver.findElement(ageField).clear(); // Clear field before entering new value
        driver.findElement(ageField).sendKeys(age);
    }

    public void enterSalary(String salary) {
        driver.findElement(salaryField).clear(); // Clear field before entering new value
        driver.findElement(salaryField).sendKeys(salary);
    }

    public void enterDepartment(String department) {
        driver.findElement(departmentField).clear(); // Clear field before entering new value
        driver.findElement(departmentField).sendKeys(department);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    // Optionally, you could add a method to verify the form is displayed
    public boolean isFormDisplayed() {
        return driver.findElement(firstNameField).isDisplayed(); // Check if the first name field is displayed
    }
}
