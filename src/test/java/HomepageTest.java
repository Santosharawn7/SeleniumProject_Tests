import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class HomepageTest extends SeleniumTest{

    @Test
    public void TestRunForHomePage(){
        driver.findElement(By.xpath("//a[normalize-space()='A/B Testing']")).click();
        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));

        String title_text = webElement.getText();
        String expectedTitleText = "A/B Test Variation 1";
        String random_expectation = "A/B Test Control";

        if (Objects.equals(title_text, expectedTitleText)){
            System.out.println(title_text);
            Assert.assertEquals(expectedTitleText, title_text);
        } else {
            System.out.println(title_text);
            Assert.assertEquals(random_expectation, title_text);
        }

    }


}
