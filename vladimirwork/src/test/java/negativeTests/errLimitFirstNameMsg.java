package negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.safari.SafariDriver;
import preConditions.errMessages;
import preConditions.variables;

public class errLimitFirstNameMsg {
    public static void main(String[] args) {
        int i = 1;

        SafariDriver driver = new SafariDriver();

        System.out.println("\n Start of " + errLimitFirstNameMsg.class + "\n");

        driver.get(variables.URL);
        driver.findElement(By.id(variables.submitBtn)).click();
        driver.findElement(By.id(variables.firstNameInput)).sendKeys(variables.validMinFirstName);
        driver.findElement(By.id(variables.lastNameInput)).sendKeys(variables.validMinLastName);
        driver.findElement(By.id(variables.emailInput)).sendKeys(variables.validMinEmail);
        driver.findElement(By.id(variables.phoneNumberInput)).sendKeys(variables.validMinPhoneNumber);
        driver.findElement(By.id(variables.agreementCheckbox)).click();
        driver.findElement(By.cssSelector("input[value = 'Male']")).click();

        while ((!driver.getPageSource().contains(errMessages.errFirstName))) {
            driver.findElement(By.id(variables.firstNameInput)).sendKeys("B");
            i++;
            if (i > 255 && !driver.getPageSource().contains(errMessages.errFirstName)) {

                System.out.println("Limit is more than 256, no validation error. Terminated.");
                break;
            }
        }


        driver.findElement(By.id(variables.submitBtn)).click();
        if (driver.getPageSource().contains(errMessages.errFirstName)) {
            System.out.println("Page still contains validation error");
        }

        System.out.println("Limit of FirstName letters is: " + i);
        driver.quit();
    }
}
