package positiveTests;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import preConditions.variables;

public class validMinSubmitMale {
    static SafariDriver driver;
    static String firstName;
    static String lastName;
    static String phoneNumber;
    static String email;
    static String gender;
    static String boolAgreement;
    @BeforeTest
    public void submitMale() {
        driver = new SafariDriver();
        driver.get(variables.URL);

        driver.findElement(By.id(variables.firstNameInput)).sendKeys(variables.validMinFirstName);
        driver.findElement(By.id(variables.lastNameInput)).sendKeys(variables.validMinLastName);
        driver.findElement(By.id(variables.emailInput)).sendKeys(variables.validMinEmail);
        driver.findElement(By.id(variables.phoneNumberInput)).sendKeys(variables.validMinPhoneNumber);
        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[1]/input")).click();
        driver.findElement(By.id(variables.agreementCheckbox)).click();
        driver.findElement(By.id(variables.submitBtn)).click();

        String log = driver.switchTo().alert().getText();
        JSONObject jsonobject = new JSONObject(log);

        firstName = jsonobject.getString("FirstName");
        lastName = jsonobject.getString("LastName");
        email = jsonobject.getString("Email");
        phoneNumber = jsonobject.getString("PhoneNumber");
        gender = jsonobject.getString("Gender");
        boolAgreement = String.valueOf(jsonobject.getBoolean("Agreement"));

        driver.switchTo().alert().dismiss();


    }
    @AfterTest
    public static void safariQuit() {
        driver.quit();
    }
    @Test
    public static void FirstNameTest() {
        Assert.assertEquals(firstName, variables.validMinFirstName);
    }

    @Test
    public static void LastNameTest() {
        Assert.assertEquals(lastName, variables.validMinLastName);
    }
    @Test
    public static void EmailTest() {
        Assert.assertEquals(email, variables.validMinEmail);
    }
    @Test
    public static void PhoneNumberTest() {
        Assert.assertEquals(phoneNumber, variables.validMinPhoneNumber);
    }
    @Test
    public static void GenderTest() {
        Assert.assertEquals(gender, variables.male);
    }
    @Test
    public static void AgreementTest() {
        Assert.assertEquals(boolAgreement, variables.boolAgreementTrue);
    }
}


