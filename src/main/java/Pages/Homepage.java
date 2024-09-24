package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class Homepage {
    WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    By listofItems = By.xpath("//div[@id='content']//a");

    List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listofItems));


    public Homepage (WebDriver driver){
        this.driver = driver;
    }

    public void ListAllElements() {
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
    }

    public void AddRemoveElements() {
        for (WebElement element : elements) {
            System.out.println(element.getText());

            wait.until(ExpectedConditions.elementToBeClickable(element));

            if (element.getText().equals("Add/Remove Elements")) {
                element.click();
                break;
            }
        }
    }
}
