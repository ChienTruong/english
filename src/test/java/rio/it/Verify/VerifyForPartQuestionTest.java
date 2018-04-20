package rio.it.Verify;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import rio.it.App.Util.Impl.VerifyForPartSix;

/**
 * Created by chien on 20/04/2018.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                VerifyForPartOneTest.class,
                VerifyForPartTwoTest.class,
                VerifyForPartFourTest.class,
                VerifyForPartFiveTest.class,
                VerifyForPartSix.class,
                VerifyForPartSevenTest.class
        }
)
public class VerifyForPartQuestionTest {
}
