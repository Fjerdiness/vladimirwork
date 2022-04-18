package negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import positiveTests.validSubmitFemale;
import preConditions.errMessages;
import preConditions.variables;

public class errNotValidInput {
    public static void main(String[] args) {
        SafariDriver driver = new SafariDriver();
        System.out.println("\n Start of " + errNotValidInput.class + "\n");

        driver.get(variables.URL);

        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id(variables.firstNameInput)).sendKeys("q@e$t_uiop");
            driver.findElement(By.id(variables.lastNameInput)).sendKeys("q@e$t_uiop");
            driver.findElement(By.id(variables.emailInput)).sendKeys("q@e$t_uiop");
            driver.findElement(By.id(variables.phoneNumberInput)).sendKeys("q@e$t_uiop");
        }
        driver.findElement(By.id(variables.submitBtn)).click();

        if (driver.getPageSource().contains(errMessages.errFirstName)) {
            System.out.println(errMessages.errFirstName + " Is presented!");
        } else System.out.println(errMessages.errFirstName + " Isn't presented!");

        if (driver.getPageSource().contains(errMessages.errLastName)) {
            System.out.println(errMessages.errLastName + " Is presented!");
        } else System.out.println(errMessages.errLastName + " Isn't presented!");

        if (driver.getPageSource().contains(errMessages.errEmail)) {
            System.out.println(errMessages.errEmail + " Is presented!");
        } else System.out.println(errMessages.errEmail + " Isn't presented!");

        if (driver.getPageSource().contains(errMessages.errPhoneNumber)) {
            System.out.println(errMessages.errPhoneNumber + " Is presented!");
        } else System.out.println(errMessages.errPhoneNumber + " Isn't presented!");

        if (driver.getPageSource().contains(errMessages.errGender)) {
            System.out.println(errMessages.errGender + " Is presented!");
        } else System.out.println(errMessages.errGender + " Isn't presented!");

        if (driver.getPageSource().contains(errMessages.errPersData)) {
            System.out.println(errMessages.errPersData + " Is presented!");
        } else System.out.println(errMessages.errPersData + " Isn't presented!");

        driver.quit();
    }
}
