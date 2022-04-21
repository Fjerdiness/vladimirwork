package FirstName;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import preConditions.errMessages;
import preConditions.variables;

public class errMaxFirstNameLimit {
    static SafariDriver driver;
    @BeforeTest
    public void preConditions() {
        driver = new SafariDriver();
        driver.get(variables.URL);
        driver.findElement(By.id(variables.submitBtn)).click();
        driver.findElement(By.id(variables.firstNameInput)).sendKeys(variables.validMinFirstName);
    }
    @AfterTest
    public void SafariQuit() {
        driver.quit();
    }
    @Test
    void errMaxLimitFirstName() {
        while (!(driver.findElement(By.xpath("//*[@id=\"root\"]/form/p/text()")).getText().equals(errMessages.errFirstName))) {
            driver.findElement(By.id(variables.firstNameInput)).sendKeys("T");
            if (driver.findElement(By.xpath("//*[@id=\"root\"]/form/p/text()")).getText().equals(errMessages.errFirstName)) {
                break;
            }
        }
    }
}
