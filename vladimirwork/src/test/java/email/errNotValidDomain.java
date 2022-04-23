package negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import preConditions.errMessages;
import preConditions.variables;


public class errNotValidDomain {
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
    public static void errInvalidDomain() {
        driver.findElement(By.id(variables.emailInput)).sendKeys(variables.validMinEmail);
        while ((!driver.getPageSource().contains(errMessages.errEmail))) {
            driver.findElement(By.id(variables.emailInput)).sendKeys(Keys.BACK_SPACE);
        }
        if (driver.getPageSource().contains(errMessages.errEmail)) {
            System.out.println(driver.findElement(By.id(variables.emailInput)).getText() + " isn't valid email");
        } else System.out.println("Something happened here");
        //TODO Why not showing text from email field?
    }
}
