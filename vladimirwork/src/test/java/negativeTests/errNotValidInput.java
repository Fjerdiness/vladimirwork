package negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import preConditions.errMessages;
import preConditions.variables;

public class errNotValidInput {
    static SafariDriver driver;
    @BeforeTest
    public void preConditions() {
        driver = new SafariDriver();
        driver.get(variables.URL);
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id(variables.firstNameInput)).sendKeys("q@e$t_uiop");
            driver.findElement(By.id(variables.lastNameInput)).sendKeys("q@e$t_uiop");
            driver.findElement(By.id(variables.emailInput)).sendKeys("q@e$t_uiop");
            driver.findElement(By.id(variables.phoneNumberInput)).sendKeys("q@e$t_uiop");
        }
        driver.findElement(By.id(variables.submitBtn)).click();
    }
    @AfterTest
    public void SafariQuit() {
        driver.quit();
    }

        @Test
        public static void errMaxLimitMsgFirstName() {
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/form/p[1]/text()")).getText(), errMessages.errFirstName);
        }

        @Test
        public static void errMaxLimitMsgLastName() {
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/form/p[2]/text()")).getText(), errMessages.errLastName);
        }
        @Test
        public static void errMaxLimitMsgEmail() {
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/form/p[3]/text()")).getText(), errMessages.errEmail);
        }
        @Test
        public static void errMaxLimitMsgPhoneNumber() {
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/form/p[4]/text()")).getText(), errMessages.errPhoneNumber);
        }
        @Test
        public static void errMaxLimitMsgGender() {
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/form/p[5]/text()")).getText(), errMessages.errGender);
        }
        @Test
        public static void errMaxLimitMsgAgreement() {
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/form/p[6]/text()")).getText(), errMessages.errPersData);
        }
    }

