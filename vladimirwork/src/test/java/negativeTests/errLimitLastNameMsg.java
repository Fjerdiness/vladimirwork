package negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import preConditions.errMessages;
import preConditions.variables;

public class errLimitLastNameMsg {
    public static void main(String[] args) {
        int i = 1;

        SafariDriver driver = new SafariDriver();

        System.out.println("\n Start of " + errLimitLastNameMsg.class + "\n");

        driver.get(variables.URL);
        driver.findElement(By.id(variables.submitBtn)).click();
        driver.findElement(By.id(variables.lastNameInput)).sendKeys(variables.validMinLastName);

        while ((!driver.getPageSource().contains(errMessages.errLastName))) {
            driver.findElement(By.id(variables.lastNameInput)).sendKeys("B");
            i++;
            if (i > 255 && !driver.getPageSource().contains(errMessages.errLastName)) {

                System.out.println("Limit is more than 256, no validation error. Terminated.");
                break;
            }
        }
        driver.findElement(By.id(variables.submitBtn)).click();
        if (driver.getPageSource().contains(errMessages.errLastName)) {
            System.out.println("Page still contatins validation error");
        }

        System.out.println("Limit of LastName letters is: " + i);
        driver.quit();
    }
}
