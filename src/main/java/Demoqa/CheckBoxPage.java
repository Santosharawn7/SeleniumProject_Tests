package Demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // CSS Selectors for the checkboxes and toggle buttons
    private By toggleHomeButton = By.cssSelector(".rct-collapse-btn"); // Toggle button for "Home"
    private By homeCheckBox = By.cssSelector("#tree-node-home + span .rct-icon"); // "Home" checkbox icon
    private By desktopCheckBox = By.cssSelector("#tree-node-desktop + span .rct-icon"); // "Desktop" checkbox icon
    private By documentsCheckBox = By.cssSelector("#tree-node-documents + span .rct-icon"); // "Documents" checkbox icon
    private By downloadsCheckBox = By.cssSelector("#tree-node-downloads + span .rct-icon"); // "Downloads" checkbox icon
    private By confirmText = By.id("result"); // Confirmation text element

    public CheckBoxPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Getter methods for elements
    public WebElement getToggleHomeButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(toggleHomeButton));
        return driver.findElement(toggleHomeButton);
    }

    public WebElement getHomeCheckBox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeCheckBox));
        return driver.findElement(homeCheckBox);
    }

    public WebElement getDesktopCheckBox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(desktopCheckBox));
        return driver.findElement(desktopCheckBox);
    }

    public WebElement getDocumentsCheckBox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(documentsCheckBox));
        return driver.findElement(documentsCheckBox);
    }

    public WebElement getDownloadsCheckBox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(downloadsCheckBox));
        return driver.findElement(downloadsCheckBox);
    }

    public WebElement getConfirmText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmText));
        return driver.findElement(confirmText);
    }

    // Check if checkboxes are checked by inspecting the class
    public boolean isHomeChecked() {
        return getHomeCheckBox().getAttribute("class").contains("rct-icon-check");
    }

    public boolean isDesktopChecked() {
        return getDesktopCheckBox().getAttribute("class").contains("rct-icon-check");
    }

    public boolean isDocumentsChecked() {
        return getDocumentsCheckBox().getAttribute("class").contains("rct-icon-check");
    }

    public boolean isDownloadsChecked() {
        return getDownloadsCheckBox().getAttribute("class").contains("rct-icon-check");
    }

    // Check if Home is expanded
    public boolean isHomeExpanded() {
        return getToggleHomeButton().getAttribute("class").contains("rct-icon-expand-open");
    }
}
