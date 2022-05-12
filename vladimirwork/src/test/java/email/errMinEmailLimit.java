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

public class errMinEmailLimit {
    static SafariDriver driver;
    static int _emailInput;
    @BeforeTest (groups = {"Negative", "Email"})
    void preConditions() {
        driver = new SafariDriver();
        driver.get(variables.URL);
        driver.findElement(By.id(variables.submitBtn)).click();
        driver.findElement(By.id(variables.emailInput)).sendKeys(variables.validMinEmail);
    }
    @AfterTest (groups = {"Negative", "Email"})
    void SafariQuit() {
        driver.quit();
    }
    @Test (groups = {"Negative", "Email"})
    public void errMinEmailLimit() {
        while (!driver.getPageSource().contains(errMessages.errEmail)) {
            driver.findElement(By.id(variables.emailInput)).sendKeys(Keys.BACK_SPACE);
            if (driver.getPageSource().contains(errMessages.errEmail)) {
                Assert.assertTrue(driver.getPageSource().contains(errMessages.errEmail));
            }
        }
    }
}
