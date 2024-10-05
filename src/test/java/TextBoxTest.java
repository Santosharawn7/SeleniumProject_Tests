import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class TextBoxTest extends SeleniumExecutorForDemoQA {

    // Expected output values for validation
    String expectedName = "Yanice";
    String expectedEmail = "abc@gmail.com";
    String expectedCurrentAddress = "HK";
    String expectedPermanentAddress = "HK";

    @Test
    void fillTextBox() {
        // Navigating to the TextBox (Abstraction)
        homePage.navigateToCard("Elements"); // Utilizing the navigate method for cleaner code
        homePage.navigateToItem("Text Box"); // Abstraction allows hiding implementation details

        // Filling out the text box form (Encapsulation)
        textBoxPage.fillFullName("Yanice"); // Method calls abstract the filling logic
        textBoxPage.fillEmail("abc@gmail.com");
        textBoxPage.fillCurrentAddress("HK");
        textBoxPage.fillPermanentAddress("HK");
        textBoxPage.clickSubmitButton(); // Encapsulation of click action
        textBoxPage.getOutputInfo(); // Retrieving output info encapsulated in a method

        // Validate the output (Polymorphism and Encapsulation)
        Assert.assertTrue(textBoxPage.getOutputName().contains(expectedName), "Name output doesn't match!"); // Using assertion for verification
        Assert.assertTrue(textBoxPage.getOutputEmail().contains(expectedEmail), "Email output doesn't match!");
        Assert.assertTrue(textBoxPage.getOutputCurrentAddress().contains(expectedCurrentAddress), "Current Address output doesn't match!");
        Assert.assertTrue(textBoxPage.getOutputPermanentAddress().contains(expectedPermanentAddress), "Permanent Address output doesn't match!");
    }

    @Test
    void fillTextBoxFromExcel() {
        // File path to the Excel file
        String filePath = System.getProperty("user.dir") + "/Data/data.xlsx"; // Update this with the correct path to your Excel file
        int sheetIndex = 2; // Index of the sheet (0-based index)
        int rowIndex = 1; // Index of the row (1-based index for the second row)

        String[] inputData;
        try {
            // Read data from Excel
            inputData = textBoxPage.readDataFromExcel(filePath, sheetIndex, rowIndex);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Failed to read data from Excel file.");
            return; // Exit the test if data reading fails
        }

        // Navigating to the TextBox (Abstraction)
        homePage.navigateToCard("Elements"); // Utilizing the navigate method for cleaner code
        homePage.navigateToItem("Text Box"); // Abstraction allows hiding implementation details

        // Filling out the text box form (Encapsulation)
        textBoxPage.fillFullName(inputData[0]); // Use data from Excel
        textBoxPage.fillEmail(inputData[1]);
        textBoxPage.fillCurrentAddress(inputData[2]);
        textBoxPage.fillPermanentAddress(inputData[3]);
        textBoxPage.clickSubmitButton(); // Encapsulation of click action
        textBoxPage.getOutputInfo(); // Retrieving output info encapsulated in a method

        // Validate the output (Polymorphism and Encapsulation)
        Assert.assertTrue(textBoxPage.getOutputName().contains(inputData[0]), "Name output doesn't match!"); // Using assertion for verification
        Assert.assertTrue(textBoxPage.getOutputEmail().contains(inputData[1]), "Email output doesn't match!");
        Assert.assertTrue(textBoxPage.getOutputCurrentAddress().contains(inputData[2]), "Current Address output doesn't match!");
        Assert.assertTrue(textBoxPage.getOutputPermanentAddress().contains(inputData[3]), "Permanent Address output doesn't match!");
    }

}
