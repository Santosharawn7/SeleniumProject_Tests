import org.testng.annotations.Test;

public class TextBoxTest extends SeleniumExecutorForDemoQA {

    @Test
    void fillTextBox(){
        driver.get("https://demoqa.com/text-box");
        textBoxPage.fillFullName();
        textBoxPage.fillEmail();
        textBoxPage.fillCurrentAddress();
        textBoxPage.fillPermanentAddress();
    }

}
