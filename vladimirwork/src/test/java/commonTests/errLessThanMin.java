package commonTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import preConditions.errMessages;
import preConditions.variables;

public class errLestThanMin {
    static SafariDriver driver;
    static int i = 1;
    @BeforeTest
    public void preConditions() {
        driver = new SafariDriver();
        driver.get(variables.URL);
        driver.findElement(By.id(variables.submitBtn)).click();
        driver.findElement(By.id(variables.firstNameInput)).sendKeys(variables.validMinFirstName);
        driver.findElement(By.id(variables.lastNameInput)).sendKeys(variables.validMinLastName);
        driver.findElement(By.id(variables.emailInput)).sendKeys(variables.validMinEmail);
        driver.findElement(By.id(variables.phoneNumberInput)).sendKeys(variables.validMinPhoneNumber);
    }
    @BeforeTest (dependsOnMethods = "preConditions")
    void firstNameMoreThanMax() {
        i = 0;
        while (!driver.getPageSource().contains(errMessages.errFirstName)) {
            driver.findElement(By.id(variables.firstNameInput)).sendKeys(Keys.BACK_SPACE);
            i++;
            if (!driver.getPageSource().contains(errMessages.errFirstName) && i > 255) {
                break;
            }
        }
    }
    @BeforeTest (dependsOnMethods = "preConditions")
    void lastNameMoreThanMax() {
        i = 0;
        while (!driver.getPageSource().contains(errMessages.errLastName)) {
            driver.findElement(By.id(variables.lastNameInput)).sendKeys(Keys.BACK_SPACE);
            i++;
            if (!driver.getPageSource().contains(errMessages.errLastName) && i > 255) {
                break;
            }
        }
    }
    @BeforeTest (dependsOnMethods = "preConditions")
    void emailMoreThanMax() {
        i = 0;
        while (!driver.getPageSource().contains(errMessages.errEmail)) {
            driver.findElement(By.id(variables.emailInput)).sendKeys(Keys.BACK_SPACE);
            i++;
            if (!driver.getPageSource().contains(errMessages.errEmail) && i > 255) {
                break;
            }
        }
    }
    @BeforeTest (dependsOnMethods = "preConditions")
    void phoneNumberMoreThanMax() {
        i = 0;
        while (!driver.getPageSource().contains(errMessages.errPhoneNumber)) {
            i++;
            driver.findElement(By.id(variables.phoneNumberInput)).sendKeys(Keys.BACK_SPACE);
            if (!driver.getPageSource().contains(errMessages.errPhoneNumber) && i > 255) {
                break;
            }
        }
    }

    @AfterTest
    public void SafariQuit() {
        driver.quit();
    }

    @Test
    public static void errMsgFirstName() {
        Assert.assertTrue(driver.getPageSource().contains(errMessages.errFirstName), "No firstName validation");
    }

    @Test
    public static void errMsgLastName() {
        Assert.assertTrue(driver.getPageSource().contains(errMessages.errLastName), "No lastName validation");
    }
    @Test
    public static void errMsgEmail() {
        Assert.assertTrue(driver.getPageSource().contains(errMessages.errEmail), "No email validation");
    }
    @Test
    public static void errMsgPhoneNumber() {
        Assert.assertTrue(driver.getPageSource().contains(errMessages.errPhoneNumber), "No phoneNumber validation");
    }
    @Test
    public static void errMsgGender() {
        Assert.assertTrue(driver.getPageSource().contains(errMessages.errGender), "No gender radiobutton validation");
    }
    @Test
    public static void errMsgAgreement() {
        Assert.assertTrue(driver.getPageSource().contains(errMessages.errAgreement), "No agreement checkbox validation");
    }
}


