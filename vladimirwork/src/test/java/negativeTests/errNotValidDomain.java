package negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.safari.SafariDriver;
import preConditions.errMessages;
import preConditions.variables;

public class errNotValidEmail {
    public static void main(String[] args) {
        SafariDriver driver = new SafariDriver();

        System.out.println("\n Start of " + errNotValidEmail.class + "\n");

        driver.get("https://vladimirwork.github.io/web-ui-playground/");

        driver.findElement(By.id("99")).click();
        driver.findElement(By.id("3")).sendKeys(variables.validMinEmail);

         do {
            driver.findElement(By.id("3")).sendKeys(Keys.BACK_SPACE);
        }while ((!driver.getPageSource().contains(errMessages.errEmail)));
    }
}
