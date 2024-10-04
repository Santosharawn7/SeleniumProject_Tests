package Demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage {
    private WebDriver driver;

    private By fullName = By.id("userName");
    private By email = By.id("userEmail");
    private By currentAddress = By.id("currentAddress");
    private By permanentAddress = By.id("permanentAddress");

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFullName() {
        driver.findElement(fullName).sendKeys("Yanice");
    }

    public void fillEmail() {
        driver.findElement(email).sendKeys("abc@gmail.com");
    }

    public void fillCurrentAddress() {
        driver.findElement(currentAddress).sendKeys("HK");
    }

    public void fillPermanentAddress() {
        driver.findElement(permanentAddress).sendKeys("HK");
    }






}
