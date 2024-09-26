package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddOrRemoveElementsPage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public AddOrRemoveElementsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Locators
    By elementsList = By.xpath("//div[@id='content']//a");
    By addButton = By.xpath("//*[@id=\"content\"]/div/button");
    By deleteButton = By.xpath("//*[@id=\"elements\"]/button");

    // Methods for interacting with elements
    public List<WebElement> getAllElements() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementsList));
    }

    public void clickElement(String elementText) {
        for (WebElement element : getAllElements()) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            if (element.getText().equals(elementText)) {
                element.click();
                break;
            }
        }
    }

    public void clickAddButton() {
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addBtn.click();
    }

    public void clickDeleteButton() {
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteBtn.click();
    }

    public boolean isDeleteButtonInvisible() {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(deleteButton));
    }
}

