package ExcelTests;

import Pages.AddOrRemoveElementsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddAndRemoveElementsTest extends SeleniumTest {

    private AddOrRemoveElementsPage addRemoveElementsPage;

    @BeforeClass
    public void setUp() {
        WebDriver driver = getDriver();  // Assuming getDriver() is defined in ExcelTests.SeleniumTest
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        addRemoveElementsPage = new AddOrRemoveElementsPage(driver, wait);
    }

    @Test
    public void addElements() {
        addRemoveElementsPage.clickElement("Add/Remove Elements");
        addRemoveElementsPage.clickAddButton();
    }

    @Test
    public void removeElements() {
        addRemoveElementsPage.clickDeleteButton();

        boolean isDeleted = addRemoveElementsPage.isDeleteButtonInvisible();

        if (isDeleted) {
            System.out.println("Element is not visible.");
        } else {
            System.out.println("Element is still visible.");
        }
    }
}