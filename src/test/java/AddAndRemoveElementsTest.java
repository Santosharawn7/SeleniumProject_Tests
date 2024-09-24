import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import java.util.List;

public class AddAndRemoveElementsTest extends SeleniumTest {

    @Test
    public void AddElements() {

        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='content']//a")));
        for (WebElement element : elements) {
            System.out.println(element.getText());

            wait.until(ExpectedConditions.elementToBeClickable(element));

            if (element.getText().equals("Add/Remove Elements")) {
                element.click();
                break;
            }
        }

        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/button")));
        addButton.click();
    }


    @Test
    public void RemoveElements() {

        WebElement deleteElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"elements\"]/button")));
        deleteElement.click();

        boolean isDeleted = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"elements\"]/button")));

        if (isDeleted) {
            System.out.println("Element is not visible.");
        } else {
            System.out.println("Element is still visible.");
        }
    }
}
