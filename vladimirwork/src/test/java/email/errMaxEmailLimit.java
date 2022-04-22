package firstName;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import preConditions.errMessages;
import preConditions.variables;

public class errMaxFirstNameLimit {
    static SafariDriver driver;
    @BeforeTest (groups = {"Negative", "FirstName"})
    public void preConditions() {
        driver = new SafariDriver();
        driver.get(variables.URL);
        driver.findElement(By.id(variables.submitBtn)).click();
        driver.findElement(By.id(variables.firstNameInput)).sendKeys(variables.validMinFirstName);
    }
    @AfterTest (groups = {"Negative", "FirstName"})
    public void SafariQuit() {
        driver.quit();
    }
    @Test (groups = {"Negative", "FirstName"})
    void errMaxFirstNameLimit() {
        while (!driver.getPageSource().contains(errMessages.errFirstName)) {
            driver.findElement(By.id(variables.firstNameInput)).sendKeys("T");
            if (driver.getPageSource().contains(errMessages.errFirstName)) {
                Assert.assertTrue(driver.getPageSource().contains(errMessages.errFirstName));
            }
        }
    }
}
