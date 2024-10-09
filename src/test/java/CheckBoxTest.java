import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CheckBoxTest extends SeleniumExecutorForDemoQA {

    @Test
    void clickHomeCheckBox() {
        homePage.navigateToCard("Elements");
        homePage.navigateToItem("Check Box");

        wait.until(ExpectedConditions.elementToBeClickable(checkBoxPage.getToggleHomeButton()));
        checkBoxPage.getToggleHomeButton().click();

        // Toggle the Home checkbox based on its current state
        if (checkBoxPage.isHomeChecked()) {
            System.out.println("Home checkbox is already checked. Unchecking now...");
            checkBoxPage.getHomeCheckBox().click(); // Uncheck
        } else {
            System.out.println("Home checkbox is unchecked. Checking now...");
            checkBoxPage.getHomeCheckBox().click(); // Check
        }

        // Verify if the confirmation text is displayed after checking the checkbox of Home Checkbox
        assert checkBoxPage.getConfirmText().isDisplayed();
        System.out.println("Checked status of Home: " + checkBoxPage.isHomeChecked());

       // Uncheck the Home checkbox after the confirmations so other checkbox test can be run
        if (checkBoxPage.isHomeChecked()) {
            System.out.println("Unchecking Home checkbox after test...");
            checkBoxPage.getHomeCheckBox().click(); // Uncheck
        }

        // Verify if the Home checkbox is now unchecked
        assert !checkBoxPage.isHomeChecked();
        System.out.println("Home checkbox is now unchecked.");
    }

    @Test(dependsOnMethods = {"clickHomeCheckBox"})
    void clickDesktopCheckBox() {
        // Ensure Home is expanded before checking the Desktop checkbox
        if (!checkBoxPage.getDesktopCheckBox().isDisplayed()) {
            checkBoxPage.getToggleHomeButton().click(); // Expand Home if collapsed
        }
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxPage.getDesktopCheckBox()));
        // Check if the Desktop checkbox is already checked
        if (checkBoxPage.isDesktopChecked()) {
            System.out.println("Desktop checkbox is already checked. Unchecking now...");
            checkBoxPage.getDesktopCheckBox().click(); // Uncheck
        } else {
            System.out.println("Desktop checkbox is unchecked. Checking now...");
            checkBoxPage.getDesktopCheckBox().click(); // Check
        }

        // Verify if the confirmation text is displayed
        assert checkBoxPage.getConfirmText().isDisplayed();
        System.out.println("Checked status of Desktop: " + checkBoxPage.isDesktopChecked());
    }

    @Test(dependsOnMethods = {"clickHomeCheckBox"})
    void clickDocumentsCheckBox() {
        // Ensure Home is expanded before checking the Documents checkbox
        if (!checkBoxPage.getDocumentsCheckBox().isDisplayed()) {
            checkBoxPage.getToggleHomeButton().click(); // Expand Home if collapsed
        }
        // Wait for Documents checkbox to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxPage.getDocumentsCheckBox()));
        // Toggle the Documents checkbox based on its current state
        if (checkBoxPage.isDocumentsChecked()) {
            System.out.println("Documents checkbox is already checked. Unchecking now...");
            checkBoxPage.getDocumentsCheckBox().click(); // Uncheck
        } else {
            System.out.println("Documents checkbox is unchecked. Checking now...");
            checkBoxPage.getDocumentsCheckBox().click(); // Check
        }

        // Verify if the confirmation text is displayed
        assert checkBoxPage.getConfirmText().isDisplayed();
        System.out.println("Checked status of Documents: " + checkBoxPage.isDocumentsChecked());
    }

    @Test(dependsOnMethods = {"clickHomeCheckBox"})
    void clickDownloadsCheckBox() {
        // Ensure Home is expanded before checking the Downloads checkbox
        if (!checkBoxPage.getDownloadsCheckBox().isDisplayed()) {
            checkBoxPage.getToggleHomeButton().click(); // Expand Home if collapsed
        }
        // Wait for Downloads checkbox to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxPage.getDownloadsCheckBox()));
        // Toggle the Downloads checkbox based on its current state
        if (checkBoxPage.isDownloadsChecked()) {
            System.out.println("Downloads checkbox is already checked. Unchecking now...");
            checkBoxPage.getDownloadsCheckBox().click(); // Uncheck
        } else {
            System.out.println("Downloads checkbox is unchecked. Checking now...");
            checkBoxPage.getDownloadsCheckBox().click(); // Check
        }

        // Verify if the confirmation text is displayed
        assert checkBoxPage.getConfirmText().isDisplayed();
        System.out.println("Checked status of Downloads: " + checkBoxPage.isDownloadsChecked());
    }
}
