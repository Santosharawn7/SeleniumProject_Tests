import Demoqa.HomePage;
import Demoqa.TextBoxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class SeleniumExecutorForDemoQA {
    public static ChromeOptions options;
    public static WebDriver driver;
    public static WebDriverWait wait;
    protected HomePage homePage; // Change to protected to access it in child classes\
    protected TextBoxPage textBoxPage;

    @BeforeTest
    void Setup() {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver, wait);
        textBoxPage = new TextBoxPage(driver);// Initialize here
    }

    @AfterTest
    void QuitBrowser() {
        driver.quit();
    }

}
