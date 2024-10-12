package DemoQA;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class WebTableTest extends SeleniumExecutorForDemoQA {

    @Test(priority = 1)
    public void testAddRecord() {
        homePage.navigateToCard("Elements");
        homePage.navigateToItem("Web Tables");
        // Add assertions here to verify the record was added
    }

    @Test(priority = 2)
    public void testAddNewRecordButton() {
        // Fill out the registration form
        webTablePage.clickAddNewRecord();
        webTablePage.enterFirstName("John");
        webTablePage.enterLastName("Doe");
        webTablePage.enterEmail("john.doe@example.com");
        webTablePage.enterAge("30");
        webTablePage.enterSalary("50000");
        webTablePage.enterDepartment("Engineering");
        webTablePage.clickSubmit();

        // Add assertions to verify the new record is displayed
        Assert.assertEquals(webTablePage.getCellValue(3, 0), "John", "First name does not match!");
        Assert.assertEquals(webTablePage.getCellValue(3, 1), "Doe", "Last name does not match!");
        Assert.assertEquals(webTablePage.getCellValue(3, 2), "30", "Age does not match!");
        Assert.assertEquals(webTablePage.getCellValue(3, 3), "john.doe@example.com", "Email does not match!");
        Assert.assertEquals(webTablePage.getCellValue(3, 4), "50000", "Salary does not match!");
        Assert.assertEquals(webTablePage.getCellValue(3, 5), "Engineering", "Department does not match!");
    }

    @Test(priority = 3)
    public void testSearchRecord() {
        String searchTerm = "John";
        webTablePage.search(searchTerm);
        List<WebElement> rows = webTablePage.getTableRows();
        Assert.assertTrue(rows.stream().anyMatch(row -> webTablePage.getCellData(row, 0).equals(searchTerm)));
        webTablePage.searchBox().clear();
    }

    @Test(priority = 4, dependsOnMethods = "testAddNewRecordButton")
    public void testEditRecord() {
        webTablePage.editRecord(0); // Edit first record
        webTablePage.enterAge("40");
        webTablePage.clickSubmit();

        // Assert that the record was updated correctly
        String actualAge = webTablePage.getCellValue(0, 2); // Get age from the first record
        Assert.assertEquals(actualAge, "40", "The age for the edited record was not updated correctly!");
    }

//    @Test(priority = 5, dependsOnMethods = "testAddNewRecordButton")
//    public void testDeleteRecord() {
//        int initialRowCount = webTablePage.getRowCount(); // Get the current row count
//        webTablePage.deleteRecord(0); // Delete the first record added
//        int newRowCount = webTablePage.getRowCount(); // Get the new row count
//
//        // Assert that the row count has decreased by one
//        Assert.assertEquals(newRowCount, initialRowCount - 1, "The row count did not decrease by 1 after deletion!");
//
//        // Optional: Assert that the deleted record is no longer present
//        webTablePage.search("John"); // Search for the deleted record by first name
//        List<WebElement> rows = webTablePage.getTableRows();
//        Assert.assertFalse(rows.stream().anyMatch(row -> webTablePage.getCellData(row, 0).equals("John")),
//                "The record for John should not be present after deletion!");
//    }
}
