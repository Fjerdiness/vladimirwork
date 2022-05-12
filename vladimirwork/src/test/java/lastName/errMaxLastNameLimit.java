package lastName;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import preConditions.errMessages;
import preConditions.variables;

public class errMaxLastNameLimit {
    static SafariDriver driver;
    @BeforeTest (groups = {"Negative", "LastName"})
    public void preConditions() {
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
    @AfterTest (groups = {"Negative", "LastName"})
    public void SafariQuit() {
        driver.quit();
    }
    @Test (groups = {"Negative", "LastName"})
    void errMaxLimitLastName() {
        while (!driver.getPageSource().contains(errMessages.errLastName)) {
            driver.findElement(By.id(variables.lastNameInput)).sendKeys("T");
            if (driver.getPageSource().contains(errMessages.errLastName)) {
                Assert.assertTrue(driver.getPageSource().contains(errMessages.errLastName));
            }
        }
    }
}
