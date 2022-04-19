package negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import preConditions.errMessages;
import preConditions.variables;

public class errNoDogInEmail {
    public static void main(String[] args) {
        SafariDriver driver = new SafariDriver();

        System.out.println("\n Start of " + errNoDogInEmail.class + "\n");

        driver.get(variables.URL);

        driver.findElement(By.id(variables.submitBtn)).click();
        driver.findElement(By.id(variables.emailInput)).sendKeys(variables.validMinEmail.replaceAll("\\p{Punct}",""));



        if (driver.getPageSource().contains(errMessages.errEmail)) {
            System.out.println(driver.findElement(By.id(variables.emailInput)).getText() + " isn't valid email");
        } else System.out.println("Something happened here");
        //TODO Why not showing text from email field?

        driver.quit();
    }
}
