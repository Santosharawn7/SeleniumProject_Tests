import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.FormPage;

import java.io.FileInputStream;
import java.io.IOException;

public class TestingFormWithExcel {
    public static ChromeOptions options;
    public static WebDriver driver;
    private FormPage formPage;

    @BeforeClass
    void setup() {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
        driver = new ChromeDriver(options);
        driver.get("https://automationintesting.com/selenium/testpage/");
        driver.manage().window().maximize();

        // Initialize FormPage
        formPage = new FormPage(driver);
    }

    @DataProvider(name = "formData")
    public Object[][] formData() throws IOException {
        String filePath = System.getProperty("user.dir") + "/drivers/login-data.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(1);

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        String[][] data = new String[rowCount - 1][colCount];

        // Loop through the rows and columns to extract data from the Excel file
        for (int i = 1; i < rowCount; i++) { // Start from 1 to skip the header row
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j] = cell.toString(); // Store each cell value as a string in the data array
            }
        }
        workbook.close();
        return data;
    }

    @Test(dataProvider = "formData")
    public void testForm(String firstName, String lastName, String gender, String favoriteColor,
                         String contactMethod, String comment, String visitedContinents) {
        formPage.fillFirstName(firstName);
        formPage.fillLastName(lastName);
        formPage.selectGender(gender);
        formPage.selectFavoriteColor(favoriteColor);
        formPage.selectContactMethod(contactMethod);
        formPage.fillComment(comment);
        formPage.selectContinents(visitedContinents);
        formPage.submitForm();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
