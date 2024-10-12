package ExcelTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.ExcelPage;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.IOException;

public class ExcelFileTest {
    private ExcelPage excelPage;
    private String filepath = System.getProperty("user.dir") + "/Data/Survey.xlsx";

    @BeforeClass
    public void setUp() throws IOException {
        excelPage = new ExcelPage(filepath);
    }

    @AfterClass
    public void tearDown() throws IOException {
        excelPage.closeWorkbook();
    }

    @Test
    public void testReadColumnA() {
        Sheet sheet = excelPage.getSheet(0);
        excelPage.readColumnA(sheet);
    }

    @Test
    public void testReadColumnB() {
        Sheet sheet = excelPage.getSheet(0);
        excelPage.readColumnB(sheet);
    }

    @Test
    public void testReadColumnC() {
        Sheet sheet = excelPage.getSheet(0);
        excelPage.readColumnC(sheet);
    }

    @Test
    public void testReadColumnBAndAdjacentI() {
        Sheet sheet = excelPage.getSheet(0);
        excelPage.readColumnBAndAdjacentI(sheet);
    }
}
