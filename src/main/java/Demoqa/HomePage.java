package Demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private WebDriver driver; // Encapsulation: private attributes to restrict direct access
    private WebDriverWait wait;

    // Locator for the cards on the home page
    private By cards = By.cssSelector(".card.mt-4.top-card");
    private By sideNavbarItems = By.cssSelector(".left-pannel .accordion .element-group .menu-list li");

    // Constructor (Composition): initializes the class with WebDriver and WebDriverWait objects
    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Method to get all cards (Abstraction): hides the complexity of finding elements
    public List<WebElement> getCards() {
        return driver.findElements(cards); // Encapsulation: accessing private attributes through a method
    }

    // Method to get the side navbar items (Abstraction)
    public List<WebElement> getSideNavbarItems() {
        return driver.findElements(sideNavbarItems); // Encapsulation
    }

    // Navigate to a specific card on the homepage (Abstraction)
    public void navigateToCard(String cardName) {
        List<WebElement> cardsList = getCards();
        boolean cardFound = false;

        for (WebElement card : cardsList) {
            if (card.getText().contains(cardName)) {
                // Composition: using JavaScriptExecutor to perform scroll
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card);
                // Wait for the card to be clickable and then click it
                wait.until(ExpectedConditions.elementToBeClickable(card)).click();
                cardFound = true;
                break;
            }
        }

        // Feedback if the card was not found (Encapsulation)
        if (!cardFound) {
            System.out.println("Card not found: " + cardName);
        }
    }

    // Navigate to a specific item in the left-hand side navigation (Abstraction)
    public void navigateToItem(String itemName) {
        List<WebElement> navbarItems = getSideNavbarItems();
        boolean itemFound = false;

        for (WebElement item : navbarItems) {
            if (item.getText().contains(itemName)) {
                // Composition: using JavaScriptExecutor to perform scroll
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
                // Wait for the item to be clickable and then click it
                wait.until(ExpectedConditions.elementToBeClickable(item)).click();
                itemFound = true;
                break;
            }
        }

        // Feedback if the item was not found (Encapsulation)
        if (!itemFound) {
            System.out.println("Item not found: " + itemName);
        }
    }
}
