package email;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import preConditions.errMessages;
import preConditions.variables;

public class errMaxEmailLimit {
    static SafariDriver driver;
    static int _emailInput;
    @BeforeTest (groups = {"Negative", "Email"})
    public void preConditions() {
        driver = new SafariDriver();
        driver.get(variables.URL);
        driver.findElement(By.id(variables.submitBtn)).click();
        driver.findElement(By.id(variables.emailInput)).sendKeys(variables.validMinEmail);
    }
    @AfterTest (groups = {"Negative", "Email"})
    public void SafariQuit() {
        driver.quit();
    }
    @Test (groups = {"Negative", "Email"})
    void errMaxEmailLimit() {
        while (!driver.getPageSource().contains(errMessages.errEmail)) {
            driver.findElement(By.id(variables.emailInput)).sendKeys("T");
            _emailInput = driver.findElement(By.id(variables.emailInput)).getAttribute("value").length();
            Assert.assertFalse(driver.getPageSource().contains(errMessages.errEmail));
            if (_emailInput > 25) {
                break;
            }
        }
    }
}
