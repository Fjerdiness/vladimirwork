package positiveTests;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import preConditions.variables;

import java.util.ArrayList;
import java.util.List;

import static java.awt.SystemColor.text;

public class validSubmitMale extends variables {

    //This looks nicer, now I tried to google as much as I can :)

    static SafariDriver driver;
    static String firstName;
    static String lastName;
    static String phoneNumber;
    static String email;
    static String gender;
    static String boolAgreement;
    @BeforeTest
    public void submitFemale() {
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
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public static void a_FirstNameTest() {
        Assert.assertEquals(firstName, validMinFirstName);
    }

    @Test
    public static void b_LastNameTest() {
        Assert.assertEquals(lastName, validMinLastName);
    }
    @Test
    public static void c_EmailTest() {
        Assert.assertEquals(email, validMinEmail);
    }
    @Test
    public static void d_PhoneNumberTest() {
        Assert.assertEquals(phoneNumber, validMinPhoneNumber);
    }
    @Test
    public static void e_GenderTest() {
        Assert.assertEquals(gender, male);
    }
    @Test
    public static void f_AgreementTest() {
        Assert.assertEquals(boolAgreement, boolAgreementTrue);
    }
}


