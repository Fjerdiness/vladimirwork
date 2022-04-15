import negativeTests.errCheck;
import positiveTests.validSubmitFemale;
import positiveTests.validSubmitMale;

public class startEveryTest {
    public static void main(String[] args) {

        //In Safari: Develop - allow remote automation.


        validSubmitFemale.main(args);

        validSubmitMale.main(args);

        errCheck.main(args);
    }
}
