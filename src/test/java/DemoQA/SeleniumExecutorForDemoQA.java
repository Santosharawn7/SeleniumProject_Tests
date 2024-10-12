package DemoQA;

import Demoqa.CheckBoxPage;
import Demoqa.HomePage;
import Demoqa.TextBoxPage;
import Demoqa.WebTablePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class SeleniumExecutorForDemoQA {
    public static ChromeOptions options;
    public static WebDriver driver;
    public static WebDriverWait wait;
    protected HomePage homePage; // Change to protected to access it in child classes\
    protected TextBoxPage textBoxPage;
    protected CheckBoxPage checkBoxPage;
    protected WebTablePage webTablePage;

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
        checkBoxPage = new CheckBoxPage(driver,wait);
        webTablePage = new WebTablePage(driver);
    }

//    @AfterTest
//    void QuitBrowser() {
//        driver.quit();
//    }

}
