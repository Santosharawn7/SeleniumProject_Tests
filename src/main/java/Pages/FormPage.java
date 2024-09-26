package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormPage {
    private WebDriver driver;

    // Locators for form elements
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("surname");
    private By genderDropdown = By.id("gender");
    private By redColorOption = By.id("red");
    private By blueColorOption = By.id("blue");
    private By emailCheckbox = By.id("checkbox1");
    private By phoneCheckbox = By.id("checkbox2");
    private By commentField = By.xpath("//*[@id=\"contactus\"]/div[5]/div/label/textarea");
    private By continentDropdown = By.id("continent");
    private By submitButton = By.id("submitbutton");

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void selectGender(String gender) {
        WebElement dropdown = driver.findElement(genderDropdown);
        dropdown.findElement(By.xpath("//option[text()='" + gender + "']")).click();
    }

    public void selectFavoriteColor(String favoriteColor) {
        if (favoriteColor.equalsIgnoreCase("Red")) {
            driver.findElement(redColorOption).click();
        } else {
            driver.findElement(blueColorOption).click();
        }
    }

    public void selectContactMethod(String contactMethod) {
        if (contactMethod.contains("Email")) {
            driver.findElement(emailCheckbox).click();
        } else {
            driver.findElement(phoneCheckbox).click();
        }
    }

    public void fillComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void selectContinents(String visitedContinents) {
        WebElement dropdown = driver.findElement(continentDropdown);
        for (String continent : visitedContinents.split(",")) {
            dropdown.findElement(By.xpath("//option[text()='" + continent.trim() + "']")).click();
        }
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }
}

