package positiveTests;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import preConditions.variables;

import java.util.ArrayList;
import java.util.List;

import static preConditions.variables.*;

public class validSubmitFemale {

        //Also, updated after initial sending. Just selflearaning.

        //In Safari: Develop - allow remote automation.



        static SafariDriver driver;
        @BeforeTest
        public static void newSafari() {
            driver = new SafariDriver();
        }
        @Test
        public void submitMale() {
            driver.get(variables.URL);
            driver.findElement(By.id(variables.firstNameInput)).sendKeys(validMinFirstName);
            driver.findElement(By.id(variables.lastNameInput)).sendKeys(validMinLastName);
            driver.findElement(By.id(variables.emailInput)).sendKeys(validMinEmail);
            driver.findElement(By.id(variables.phoneNumberInput)).sendKeys(variables.validMinPhoneNumber);
            driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/input")).click();
            driver.findElement(By.id(variables.agreementCheckbox)).click();
            driver.findElement(By.id(variables.submitBtn)).click();

            String log = driver.switchTo().alert().getText();
            JSONObject jsonobject = new JSONObject(log);

            String firstName = jsonobject.getString("FirstName");
            String lastName = jsonobject.getString("LastName");
            String email = jsonobject.getString("Email");
            String phoneNumber = jsonobject.getString("PhoneNumber");
            String gender = jsonobject.getString("Gender");
            String boolAgreement = String.valueOf(jsonobject.getBoolean("Agreement"));


            driver.switchTo().alert().dismiss();

                Assert.assertEquals(firstName, validMinFirstName);
                Assert.assertEquals(lastName, validMinLastName);
                Assert.assertEquals(email, validMinEmail);
                Assert.assertEquals(phoneNumber, validMinPhoneNumber);
                Assert.assertEquals(gender, female);
                Assert.assertEquals(boolAgreement, boolAgreementTrue);

            driver.quit();
        }
}
