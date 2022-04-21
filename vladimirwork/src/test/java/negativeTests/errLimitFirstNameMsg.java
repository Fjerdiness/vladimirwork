package negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import preConditions.errMessages;
import preConditions.variables;

public class errLimitFirstNameMsg {
    static SafariDriver driver;
    static int i = 1;

    @BeforeTest
    public static void preConditions() {
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
    public static void safariQuit() {
        driver.quit();
    }

    @Test
    public static void errMaxLimitFirstName() {
        while ((!driver.getPageSource().contains(errMessages.errFirstName))) {
            driver.findElement(By.id(variables.firstNameInput)).sendKeys("B");
            i++;
            if (i > 255 && !driver.getPageSource().contains(errMessages.errFirstName)) {
                System.out.println("Limit is more than 256, no validation error. Terminated.");
                break;
            }
        }
    }

    @Test (dependsOnMethods = "errMaxLimitFirstName")
    public static void errMinLimitFirstName() {
        while ((driver.getPageSource().contains(errMessages.errFirstName))) {
            driver.findElement(By.id(variables.firstNameInput)).sendKeys(Keys.BACK_SPACE);
            i++;
            if (i == 0 && driver.getPageSource().contains(errMessages.errFirstName)) {
                System.out.println("0 letters, no validation error. Terminated.");
                break;
            }
        }
    }
}

