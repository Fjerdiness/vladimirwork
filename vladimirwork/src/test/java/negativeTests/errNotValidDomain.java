package negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.safari.SafariDriver;
import preConditions.errMessages;
import preConditions.variables;

public class errNotValidDomain {
    public static void main(String[] args) {
        SafariDriver driver = new SafariDriver();

        System.out.println("\n Start of " + errNotValidDomain.class + "\n");

        driver.get(variables.URL);

        driver.findElement(By.id(variables.submitBtn)).click();
        driver.findElement(By.id(variables.emailInput)).sendKeys(variables.validMinEmail);

        while ((!driver.getPageSource().contains(errMessages.errEmail))) {
            driver.findElement(By.id(variables.emailInput)).sendKeys(Keys.BACK_SPACE);
        }


        if (driver.getPageSource().contains(errMessages.errEmail)) {
            System.out.println(driver.findElement(By.id(variables.emailInput)).getText() + " isn't valid email");
        } else System.out.println("Something happened here");
        //TODO Why not showing text from email field?

        driver.quit();
    }
}
