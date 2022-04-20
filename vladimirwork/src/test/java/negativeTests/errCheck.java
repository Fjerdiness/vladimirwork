package negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import positiveTests.validSubmitFemale;
import preConditions.errMessages;
import preConditions.variables;

public class errCheck {
    static SafariDriver driver;
    @BeforeTest
    public void preConditions() {

        driver = new SafariDriver();

        System.out.println("\n Start of " + validSubmitFemale.class + "\n");

        driver.get(variables.URL);
        driver.findElement(By.id(variables.submitBtn)).click();
    }
    @AfterTest
    public void SafariQuit() {
        driver.quit();
    }

    @Test
    public static void errMsgFirstName() {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/form/p[1]/text()")).getText(), errMessages.errFirstName);
    }

    @Test
    public static void errMsgLastName() {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/form/p[2]/text()")).getText(), errMessages.errLastName);
    }
    @Test
    public static void errMsgEmail() {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/form/p[3]/text()")).getText(), errMessages.errEmail);
    }
    @Test
    public static void errMsgPhoneNumber() {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/form/p[4]/text()")).getText(), errMessages.errPhoneNumber);
    }
    @Test
    public static void errMsgGender() {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/form/p[5]/text()")).getText(), errMessages.errGender);
    }
    @Test
    public static void errMsgAgreement() {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/form/p[6]/text()")).getText(), errMessages.errPersData);
    }

}

