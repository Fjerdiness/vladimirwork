package utilites;

import org.openqa.selenium.Alert;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class isAlertPresent {
    SafariDriver driver = new SafariDriver();

    public boolean isAlertPresent() {
        try {
            Alert a = new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.alertIsPresent());
            if (a != null) {
                System.out.println("Alert is present");
                driver.switchTo().alert().accept();
                return true;
            } else {
                throw new Throwable();
            }
        } catch (Throwable e) {
            System.err.println("Alert isn't present!!");
            return false;
        }

    }
}