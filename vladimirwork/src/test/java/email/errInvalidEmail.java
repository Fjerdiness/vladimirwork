package email;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import preConditions.errMessages;
import preConditions.variables;

public class errInvalidEmail {
    static SafariDriver driver;
    @BeforeTest (groups = {"Negative", "Email"})
    void preConditions() {
        driver = new SafariDriver();
        driver.get(variables.URL);
        driver.findElement(By.id(variables.submitBtn)).click();
        driver.findElement(By.id(variables.firstNameInput)).sendKeys(variables.validMinFirstName);
        driver.findElement(By.id(variables.lastNameInput)).sendKeys(variables.validMinLastName);
        driver.findElement(By.id(variables.emailInput)).sendKeys(variables.validMinEmail);
        driver.findElement(By.id(variables.phoneNumberInput)).sendKeys(variables.validMinPhoneNumber);
        driver.findElement(By.id(variables.agreementCheckbox)).click();
        driver.findElement(By.cssSelector("input[value = 'Male']")).click();
    }
    @AfterTest (groups = {"Negative", "Email"})
    void SafariQuit() {
        driver.quit();
    }

    @Test (groups = {"Negative", "FirstName"})
    void errInvalidEmail() {
        while (!driver.getPageSource().contains(errMessages.errEmail)) {
            driver.findElement(By.id(variables.emailInput)).sendKeys(Keys.BACK_SPACE);
            if (driver.getPageSource().contains(errMessages.errEmail)) {
                Assert.assertTrue(driver.getPageSource().contains(errMessages.errEmail));
            }
        }
    }
}
