package negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import preConditions.errMessages;
import preConditions.variables;


public class errLimitPhoneNumberMsg {
    public static void main(String[] args) {
        int i = 6;

        SafariDriver driver = new SafariDriver();

        System.out.println("\n Start of " + errLimitLastNameMsg.class + "\n");

        driver.get(variables.URL);
        driver.findElement(By.id(variables.submitBtn)).click();
        driver.findElement(By.id(variables.phoneNumberInput)).sendKeys(variables.validMinPhoneNumber);

        while ((!driver.getPageSource().contains(errMessages.errPhoneNumber))) {
            driver.findElement(By.id(variables.phoneNumberInput)).sendKeys("1");
            i++;
        }
        driver.findElement(By.id(variables.submitBtn)).click();
        if (driver.getPageSource().contains(errMessages.errPhoneNumber)) {
            System.out.println("Page still contatins validation error");
        }
        System.out.println("Limit of PhoneNumber letters is: " + i);
        driver.quit();
    }
    }

