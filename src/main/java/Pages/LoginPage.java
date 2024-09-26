package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By formAuthenticationLink = By.xpath("//div[@id='content']//a");
    private By emailField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//*[@id=\"login\"]/button");
    private By secureAreaTitle = By.xpath("//h2[contains(text(), 'Secure Area')]");
    private By logoutButton = By.xpath("//a[@class='button secondary radius']"); // Replace with actual XPath

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void navigateToLoginForm() {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(formAuthenticationLink));
        for (WebElement element : elements) {
            if (element.getText().equals("Form Authentication")) {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                break;
            }
        }
    }

    public void enterCredentials(String email, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).clear();
        driver.findElement(emailField).sendKeys(email);

        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isLoginSuccessful() {
        WebElement titleElement = driver.findElement(secureAreaTitle);
        return titleElement != null && titleElement.getText().equals("Secure Area");
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}
