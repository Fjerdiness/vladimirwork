package firstName;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import preConditions.errMessages;
import preConditions.variables;

public class submitMaxFirstName {
    static SafariDriver driver;
    static String firstName;
    static String _firstName;
    static String lastName;
    static String phoneNumber;
    static String email;
    static String gender;
    static String boolAgreement;

    @BeforeTest (groups = {"Positive", "FirstName"})
    void preConditions() {
        driver = new SafariDriver();
        driver.get(variables.URL);

        driver.findElement(By.id(variables.lastNameInput)).sendKeys(variables.validMinLastName);
        driver.findElement(By.id(variables.emailInput)).sendKeys(variables.validMinEmail);
        driver.findElement(By.id(variables.phoneNumberInput)).sendKeys(variables.validMinPhoneNumber);
        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[1]/input")).click();
        driver.findElement(By.id(variables.agreementCheckbox)).click();
        driver.findElement(By.id(variables.submitBtn)).click();
        driver.findElement(By.id(variables.firstNameInput)).sendKeys(variables.validMinFirstName);
    }

    @AfterTest (groups = {"Positive", "FirstName"})
    public static void safariQuit() {
        driver.quit();
    }

    @Test (groups = {"Positive", "FirstName"})
    void submitMaxFirstName() {
        while (!(driver.getPageSource().contains(errMessages.errFirstName))) {
            driver.findElement(By.id(variables.firstNameInput)).sendKeys("T");
        }

        driver.findElement(By.id(variables.firstNameInput)).sendKeys(Keys.BACK_SPACE);
        _firstName = driver.findElement(By.id(variables.firstNameInput)).getAttribute("value");
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

        Assert.assertEquals(_firstName,firstName);

    }
}

