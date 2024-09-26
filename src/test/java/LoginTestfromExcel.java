import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginTestfromExcel extends SeleniumTest {
    private LoginPage loginPage;
    private String filepath = System.getProperty("user.dir") + "/drivers/login-data.xlsx";

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage(driver, wait);
    }

    @DataProvider(name = "loginData")
    public Object[][] getExcelData() {
        String[][] loginData = null;
        try {
            FileInputStream fis = new FileInputStream(filepath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

            loginData = new String[rowCount][colCount];

            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    loginData[i - 1][j] = row.getCell(j).getStringCellValue();
                }
            }
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loginData;
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String email, String password) {
        loginPage.navigateToLoginForm();
        loginPage.enterCredentials(email, password);
        loginPage.clickLogin();

        if (loginPage.isLoginSuccessful()) {
            System.out.println("Login successful and page title is 'Secure Area'");
            loginPage.clickLogout();
            System.out.println("Logout button clicked");
        } else {
            System.out.println("Login failed or title mismatch");
        }
    }
}
