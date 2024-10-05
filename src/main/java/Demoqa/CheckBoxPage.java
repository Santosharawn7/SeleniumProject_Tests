package Demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By homeCheckBox = By.xpath("l//*[@id=\"tree-node\"]/ol/li/span/label/span[1]/svg");
    private By confirmText = By.id("result/");

    public CheckBoxPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getHomeCheckBox(){
        return driver.findElement(homeCheckBox);
    }

    public WebElement getConfirmText(){
        return driver.findElement(confirmText);
    }
}
