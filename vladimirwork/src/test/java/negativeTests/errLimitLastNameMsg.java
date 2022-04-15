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

        driver.get("https://vladimirwork.github.io/web-ui-playground/");
        driver.findElement(By.id("99")).click();
        driver.findElement(By.id("2")).sendKeys(variables.validMinLastName);

        while ((!driver.getPageSource().contains(errMessages.errLastName))) {
            driver.findElement(By.id("2")).sendKeys("B");
            i++;
        }

        System.out.println("Limit of LastName letters is: " + i);
        driver.quit();
    }
}
