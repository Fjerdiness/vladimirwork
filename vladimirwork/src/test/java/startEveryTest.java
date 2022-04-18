import negativeTests.*;
import positiveTests.validSubmitFemale;
import positiveTests.validSubmitMale;

public class startEveryTest {
    public static void main(String[] args) throws InterruptedException {

        //In Safari: Develop - allow remote automation.
        validSubmitFemale.main(args);
        Thread.sleep(250);
        validSubmitMale.main(args);
        Thread.sleep(250);
        errCheck.main(args);
        Thread.sleep(250);
        errLimitLastNameMsg.main(args);
        Thread.sleep(250);
        errLimitFirstNameMsg.main(args);
        Thread.sleep(250);
        errLimitPhoneNumberMsg.main(args);
        Thread.sleep(250);
        errNoDogInEmail.main(args);
        Thread.sleep(250);
        errNoPrefixEmail.main(args);
        Thread.sleep(250);
        errNotValidDomain.main(args);
        Thread.sleep(250);
        errMaximumEmailField.main(args);
        Thread.sleep(250);
        errNotValidInput.main(args);
    }
}
