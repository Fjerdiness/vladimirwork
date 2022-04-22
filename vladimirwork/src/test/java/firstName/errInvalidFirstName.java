package FirstName;

import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import preConditions.errMessages;
import preConditions.variables;

public class errInvalidFirstName {
    //TODO little perversion with try...catch block. Need to read more.
    static SafariDriver driver;
    @BeforeTest
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
    @AfterTest
    void SafariQuit() {
        driver.quit();
    }

    @Test
    void errInvalidFirstNameOnly() {
        driver.findElement(By.id(variables.firstNameInput)).sendKeys(Keys.BACK_SPACE);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/form/p[1]/text()")).getText(), errMessages.errFirstName);
        driver.findElement(By.id(variables.submitBtn));
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
        }
    }
}
