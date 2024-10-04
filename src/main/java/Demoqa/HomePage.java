package Demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    // Locator for the cards on the home page (. for class --> cssSelector)
    private By cards = By.cssSelector(".card.mt-4.top-card");
    private By sideNavbarItems = By.cssSelector(".left-pannel .accordion .element-group .menu-list li");


    // Create getter and setter
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get all cards
    // Getter and setter for List element
    public List<WebElement> getCards() {
        return driver.findElements(cards);
    }

    // Method to click on the card with specified text
    public void clickOnCard(String cardText) {
        for (WebElement card : getCards()) {
            if (card.getText().contains(cardText)) {
                card.click();
                break;
            }
        }
    }

    public List<WebElement> getSideNavbarItems() {
        return driver.findElements(sideNavbarItems);
    }
}
