package negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import positiveTests.validSubmitFemale;
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
        }

        System.out.println("Limit of LastName letters is: " + i);
        driver.quit();
    }
}
