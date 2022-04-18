package positiveTests;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import preConditions.variables;

import java.util.ArrayList;
import java.util.List;

public class validSubmitFemale {
    public static void main(String[] args) {

        //Danila, are you crazy?! Needed to add JSON scheme validator from alert,
        //but for it I should`ve copied big parts of code from web
        //which Isnt real presentation of my zero_skills :D

        //In Safari: Develop - allow remote automation.



        SafariDriver driver = new SafariDriver();

        System.out.println("\n Start of " + validSubmitFemale.class + "\n");

        driver.get(variables.URL);

        driver.findElement(By.id(variables.firstNameInput)).sendKeys(variables.validMinFirstName);
        driver.findElement(By.id(variables.lastNameInput)).sendKeys(variables.validMinLastName);
        driver.findElement(By.id(variables.emailInput)).sendKeys(variables.validMinEmail);
        driver.findElement(By.id(variables.phoneNumberInput)).sendKeys(variables.validMinPhoneNumber);
        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/input")).click();
        driver.findElement(By.id(variables.agreementCheckbox)).click();
        driver.findElement(By.id(variables.submitBtn)).click();

        String log = driver.switchTo().alert().getText();
        List<String> listAlert = List.of(log.split(",", 0));

        List<String> listVariables = new ArrayList<>();
        listVariables.add(variables.validMinFirstName);
        listVariables.add(variables.validMinLastName);
        listVariables.add(variables.validMinEmail);
        listVariables.add(variables.validMinPhoneNumber);
        listVariables.add(variables.female);
        listVariables.add("true");

        for (int i = 0; i < listAlert.size(); i++) {
            if (listAlert.get(i).contains(listVariables.get(i))) {
                System.out.println(listVariables.get(i) + " IS presented in response!");
            } else {
                System.out.println(listVariables.get(i) + " ISNT presented in response!");
            }
        }

        driver.quit();

    }
}
