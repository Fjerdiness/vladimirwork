package negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import preConditions.errMessages;
import preConditions.variables;

public class errLimitPhoneNumberMsg {
    public static void main(String[] args) {
        int i = 6;

        SafariDriver driver = new SafariDriver();

        System.out.println("\n Start of " + errLimitLastNameMsg.class + "\n");

        driver.get("https://vladimirwork.github.io/web-ui-playground/");
        driver.findElement(By.id("99")).click();
        driver.findElement(By.id("4")).sendKeys(variables.validMinPhoneNumber);

        while ((!driver.getPageSource().contains(errMessages.errPhoneNumber))) {
            driver.findElement(By.id("4")).sendKeys("1");
            i++;
        }

        System.out.println("Limit of PhoneNumber letters is: " + i);
        driver.quit();
    }
    }

