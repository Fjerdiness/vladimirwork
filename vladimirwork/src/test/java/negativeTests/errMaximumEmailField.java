package negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import preConditions.errMessages;
import preConditions.variables;

public class errMaximumEmailField {
    public static void main(String[] args) {
        int i = 1;

        SafariDriver driver = new SafariDriver();

        System.out.println("\n Start of " + errMaximumEmailField.class + "\n");

        driver.get(variables.URL);
        driver.findElement(By.id(variables.submitBtn)).click();
        driver.findElement(By.id(variables.emailInput)).sendKeys(variables.validMinEmail);

        while ((!driver.getPageSource().contains(errMessages.errEmail))) {
            driver.findElement(By.id(variables.emailInput)).sendKeys("B");
            i += 1;
            if (i > 255) {

                System.out.println("Limit is more than 256. Terminated.");
                break;
            }
        }
        driver.quit();
    }
}

