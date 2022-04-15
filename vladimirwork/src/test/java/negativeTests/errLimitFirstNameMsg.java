package negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import positiveTests.validSubmitFemale;
import preConditions.errMessages;
import preConditions.variables;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class errLimitFirstNameMsg {
    public static void main(String[] args) {
        int i = 1;

        SafariDriver driver = new SafariDriver();

        System.out.println("\n Start of " + errLimitFirstNameMsg.class + "\n");

        driver.get("https://vladimirwork.github.io/web-ui-playground/");
        driver.findElement(By.id("99")).click();
        driver.findElement(By.id("1")).sendKeys(variables.validMinFirstName);

        while ((!driver.getPageSource().contains(errMessages.errFirstName))) {
            driver.findElement(By.id("1")).sendKeys("B");
            i++;
        }

        System.out.println("Limit of FirstName letters is: " + i);
        driver.quit();
    }
}
