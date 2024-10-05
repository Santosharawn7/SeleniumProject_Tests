package Demoqa;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;

public class TextBoxPage {
    private WebDriver driver;

    private By fullName = By.id("userName");
    private By email = By.id("userEmail");
    private By currentAddress = By.id("currentAddress");
    private By permanentAddress = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By outputBox = By.id("output");

    // Output elements for validation
    private By outputName = By.id("name");
    private By outputEmail = By.id("email");
    private By outputCurrentAddress = By.cssSelector("#output #currentAddress");
    private By outputPermanentAddress = By.cssSelector("#output #permanentAddress");

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFullName(String name) {
        driver.findElement(fullName).clear();
        driver.findElement(fullName).sendKeys(name);
    }

    public void fillEmail(String emailID) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(emailID);
    }

    public void fillCurrentAddress(String Taddress) {
        driver.findElement(currentAddress).clear();
        driver.findElement(currentAddress).sendKeys(Taddress);
    }

    public void fillPermanentAddress(String Paddresss) {
        driver.findElement(permanentAddress).clear();
        driver.findElement(permanentAddress).sendKeys(Paddresss);
    }

    public void clickSubmitButton (){
        driver.findElement(submitButton).click();
    }

    public void getOutputInfo () {
        driver.findElement(outputBox).getText();
    }


    //For Output Asserts
    // Methods to get the text from the output box
    public String getOutputName() {
        return driver.findElement(outputName).getText();
    }

    public String getOutputEmail() {
        return driver.findElement(outputEmail).getText();
    }

    public String getOutputCurrentAddress() {
        return driver.findElement(outputCurrentAddress).getText();
    }

    public String getOutputPermanentAddress() {
        return driver.findElement(outputPermanentAddress).getText();
    }

    public String[] readDataFromExcel(String filePath, int sheetIndex, int rowIndex) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);

        // Access the specified sheet
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row row = sheet.getRow(rowIndex);

        // Read data from the specified cells
        String name = row.getCell(0).getStringCellValue(); // Name
        String email = row.getCell(1).getStringCellValue(); // Email
        String currentAddress = row.getCell(2).getStringCellValue(); // Current Address
        String permanentAddress = row.getCell(3).getStringCellValue(); // Permanent Address

        // Close the workbook and input stream
        workbook.close();
        fileInputStream.close();

        return new String[]{name, email, currentAddress, permanentAddress}; // Return the data as an array
    }
}
