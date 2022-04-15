import negativeTests.errCheck;
import positiveTests.validSubmitFemale;
import positiveTests.validSubmitMale;

public class startEvery {
    public static void main(String[] args) throws InterruptedException {
        validSubmitFemale.main(args);

        validSubmitMale.main(args);

        errCheck.main(args);
    }
}
