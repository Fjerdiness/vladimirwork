package email;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import preConditions.errMessages;
import preConditions.variables;

public class errNoDogInEmail {
    static SafariDriver driver;
    @BeforeTest
    public void preConditions() {
        driver = new SafariDriver();
        driver.get(variables.URL);
        driver.findElement(By.id(variables.submitBtn)).click();
    }
    @AfterTest
    public void SafariQuit() {
        driver.quit();
    }
    @Test
    public static void errMsgNoDog() {
        driver.findElement(By.id(variables.emailInput)).sendKeys(variables.validMinEmail.replaceAll("\\p{Punct}", ""));
        driver.findElement(By.id(variables.submitBtn)).click();
        Assert.assertTrue(driver.getPageSource().contains(errMessages.errEmail));
    }
}
