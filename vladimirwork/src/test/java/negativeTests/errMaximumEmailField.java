package negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import preConditions.errMessages;
import preConditions.variables;

public class errMaximumEmailField {
    static int i = 1;
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
    public static void errMaxEmailField() {
        driver.findElement(By.id(variables.emailInput)).sendKeys(variables.validMinEmail);
        while ((!driver.getPageSource().contains(errMessages.errEmail))) {
            driver.findElement(By.id(variables.emailInput)).sendKeys("B");
            i += 1;
            driver.findElement(By.id(variables.submitBtn)).click();
            if (i > 255 && !driver.getPageSource().contains(errMessages.errEmail)) {
                System.out.println("Limit is more than 256, no validation error. Terminated.");
                break;
            }
        }
    }
}

