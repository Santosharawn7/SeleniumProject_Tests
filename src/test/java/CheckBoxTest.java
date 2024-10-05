import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CheckBoxTest extends SeleniumExecutorForDemoQA {

    @Test
    void clickCheckBox(){
        homePage.navigateToCard("Elements");
        homePage.navigateToItem("Check Box");
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxPage.getHomeCheckBox()));

        checkBoxPage.getHomeCheckBox().click();
        checkBoxPage.getConfirmText().isDisplayed();
    }
}
