package DemoQA;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


import java.util.List;

public class ElementsTest extends SeleniumExecutorForDemoQA { // abstraction

    @Test
    void listAndClickCard() {
        // Ensure that the homePage object is initialized from the parent class
        if (homePage == null) {
            System.out.println("HomePage is not initialized.");
            return; // Exit if not initialized
        }

        // List all cards and their names
        List<WebElement> cards = homePage.getCards();

        System.out.println("Cards on the homepage:");
        for (WebElement card : cards) {
            System.out.println(card.getText());
        }
        // Click on the card that has the text "Elements"
        for (WebElement card : cards) {
            if (card.getText().equals("Elements")) {
                // Scroll to the card before clicking
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card);

                // Wait until the card is clickable
                wait.until(ExpectedConditions.elementToBeClickable(card));

                // Click on the "Elements" card
                card.click();
                break;
            }
        }
    }

    @Test(dependsOnMethods = {"listAndClickCard"})
    void listSideNavbarItems() {
        // Create an instance of ElementsPage

        // List all side navbar items
        List<WebElement> navbarItems = homePage.getSideNavbarItems();

        System.out.println("Items in the Side Navbar:");
        for (WebElement item : navbarItems) {
            System.out.println(item.getText());
        }
    }

    @Test(dependsOnMethods = {"listSideNavbarItems"})
    void clickTextBox() {
        // Wait for navbar items to be visible
        List<WebElement> navbarItems = homePage.getSideNavbarItems();

        for (WebElement item : navbarItems) {
            String itemText = item.getText();
            System.out.println(itemText);

            // Check if the item text is "Text Box"
            if (itemText.equals("Text Box")) {
                // Scroll to the item before clicking
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);

                // Wait for the item to be clickable
                wait.until(ExpectedConditions.elementToBeClickable(item));

                // Click on the item
                item.click();
                break; // Stop searching after clicking
            }
        }
    }

    @Test(dependsOnMethods = {"clickTextBox"})
    void clickCheckBox() {
        List<WebElement> navbarItems = homePage.getSideNavbarItems();

        for (WebElement item : navbarItems) {
            String itemText = item.getText();
            System.out.println(itemText);

            if(itemText.equals("Check Box")){
                ((JavascriptExecutor) driver).executeScript(("arguments[0].scrollIntoView(true)"),item);

                wait.until(ExpectedConditions.elementToBeClickable(item));
                item.click();
                break;
            }
        }
    }

    @Test(dependsOnMethods = {"clickCheckBox"})
    void clickRadioButton() {
        List<WebElement> navbarItems = homePage.getSideNavbarItems();

        for (WebElement item : navbarItems) {
            String itemText = item.getText();
            System.out.println(itemText);

            if(itemText.equals("Radio Button")){
                ((JavascriptExecutor) driver).executeScript(("arguments[0].scrollIntoView(true)"),item);

                wait.until(ExpectedConditions.elementToBeClickable(item));
                item.click();
                break;
            }
        }
    }
}
