package firstName;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import preConditions.errMessages;
import preConditions.variables;

public class errMinFirstNameLimit {
    static SafariDriver driver;
    @BeforeTest (groups = {"Negative", "FirstName"})
    void preConditions() {
        driver = new SafariDriver();
        driver.get(variables.URL);
        driver.findElement(By.id(variables.submitBtn)).click();
        driver.findElement(By.id(variables.firstNameInput)).sendKeys(variables.validMinFirstName);
        driver.findElement(By.id(variables.firstNameInput)).sendKeys(Keys.BACK_SPACE);
    }
    @AfterTest (groups = {"Negative", "FirstName"})
    void SafariQuit() {
        driver.quit();
    }
    @Test (groups = {"Negative", "FirstName"})
    public void errMinLimitFirstName() {
        Assert.assertTrue(driver.getPageSource().contains(errMessages.errLastName));
    }
}
