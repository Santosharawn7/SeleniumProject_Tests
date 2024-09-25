import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class TestingFormWithExcel {
    public static ChromeOptions options;
    public static WebDriver driver;

    @BeforeClass
    void setup(){
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
        driver = new ChromeDriver(options);
        driver.get("https://automationintesting.com/selenium/testpage/");
        driver.manage().window().maximize();
    }

    @DataProvider(name = "formData")
    public Object[][] formData() throws IOException {
        String filePath = System.getProperty("user.dir") + "/drivers/login-data.xlsx";
        FileInputStream file =  new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(1);

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        String[][] data = new String[rowCount -1][colCount];

        // Loop through the rows and columns to extract data from the Excel file
        for (int i = 1; i < rowCount; i++) { // Start from 1 to skip the header row
            Row row = sheet.getRow(i);
            for(int j = 0; j< colCount; j++) {
                Cell cell = row.getCell(j);
                data[i-1][j] = cell.toString();// Store each cell value as a string in the data array
            }
        }
        workbook.close();
        return data;
    }

    @Test(dataProvider = "formData")
    public void testForm(String firstName, String lastname, String gender, String favoriteColor,
                         String contactMethod, String comment, String visitedContinents) {

        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("surname")).sendKeys(lastname);

        WebElement genderDropdown = driver.findElement(By.id("gender"));
        genderDropdown.findElement(By.xpath("//option[text()='" + gender + "']")).click();

        if(favoriteColor.equalsIgnoreCase("Red")){
            driver.findElement(By.id("red")).click();
        } else {
            driver.findElement(By.id("blue")).click();
        }

        if (contactMethod.contains("Email")){
            driver.findElement(By.id("checkbox1")).click();
        } else {
            driver.findElement(By.id("checkbox2")).click();
        }

        driver.findElement(By.xpath("//*[@id=\"contactus\"]/div[5]/div/label/textarea")).sendKeys(comment);

        WebElement continents = driver.findElement(By.id("continent"));
        for (String continent: visitedContinents.split(",")){
            continents.findElement(By.xpath("//option[text()='" + continent.trim() + "']")).click();
        }

        driver.findElement(By.id("submitbutton")).click();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

}
