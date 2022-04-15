package positiveTests;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import preConditions.variables;

import java.util.ArrayList;
import java.util.List;

public class validSubmitFemale {
    public static void main(String[] args) {

        //Danila, are you crazy?!

        //In Safari: Develop - allow remote automation.



        SafariDriver driver = new SafariDriver();

        System.out.println("\n Start of " + validSubmitFemale.class + "\n");

        driver.get("https://vladimirwork.github.io/web-ui-playground/");
        driver.manage().window().maximize();

        driver.findElement(By.id("1")).sendKeys(variables.validMinFirstName);
        driver.findElement(By.id("2")).sendKeys(variables.validMinLastName);
        driver.findElement(By.id("3")).sendKeys(variables.validMinEmail);
        driver.findElement(By.id("4")).sendKeys(variables.validMinPhoneNumber);
        driver.findElement(By.cssSelector("input[value = 'Female']")).click();
        driver.findElement(By.id("5")).click();
        driver.findElement(By.id("99")).click();

        String log = driver.switchTo().alert().getText();
        List<String> listAlert = List.of(log.split(",", 0));

        List<String> listVariables = new ArrayList<>();
        listVariables.add(variables.validMinFirstName);
        listVariables.add(variables.validMinLastName);
        listVariables.add(variables.validMinEmail);
        listVariables.add(variables.validMinPhoneNumber);
        listVariables.add(listAlert.get(4));
        listVariables.add(listAlert.get(5));

        for (int i = 0; i < listAlert.size(); i++) {
            if (listAlert.get(i).contains(listVariables.get(i))) {
                System.out.println(listVariables.get(i) + " is presented in response!");
            } else {
                System.out.println(listVariables.get(i) + " isn't presented in response!");
            }
        }

        driver.quit();

    }
}
