import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class LoginTestfromExcel extends SeleniumTest{
    String filepath = System.getProperty("user.dir") + "/drivers/login-data.xlsx";

    @DataProvider(name = "loginData")
    public Object[][] getExcelData(){
        String[][] loginData = null;
        try{
            FileInputStream fis = new FileInputStream(filepath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

            loginData = new String[rowCount][colCount];

            for(int i =1;  i <= rowCount; i++){
                Row row = sheet.getRow(i);
                for (int j= 0; j < colCount; j++) {
                    loginData[i -1][j] = row.getCell(j).getStringCellValue();
                }
            }
            workbook.close();
            fis.close();
        }catch (IOException e){
            e.printStackTrace();

        }
        return loginData;
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String email, String password){

        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='content']//a")));
        for (WebElement element : elements) {
            System.out.println(element.getText());

            wait.until(ExpectedConditions.elementToBeClickable(element));

            if (element.getText().equals("Form Authentication")) {
                element.click();
                break;
            }
        }

        WebElement emailField = driver.findElement(By.id("username")); // Replace with actual ID
        WebElement passwordField = driver.findElement(By.id("password")); // Replace with actual ID
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button")); // Replace with actual ID

        // Perform login action
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();

        // Verify that the title text is "Secure Area"
        WebElement titleElement = driver.findElement(By.xpath("//h2[contains(text(), 'Secure Area')]"));
        if (titleElement != null && titleElement.getText().equals("Secure Area")) {
            System.out.println("Login successful and page title is 'Secure Area'");

            // Now find the logout button and click it
            WebElement logoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']")); // Replace with actual XPath
            wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
            logoutButton.click();

            System.out.println("Logout button clicked");
        } else {
            System.out.println("Login failed or title mismatch");
        }

    }

}
