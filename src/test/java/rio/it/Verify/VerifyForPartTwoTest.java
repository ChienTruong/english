package rio.it.Verify;

import org.junit.Before;
import rio.it.App.Util.Impl.VerifyQuestionPartOne;
import rio.it.App.Util.Impl.VerifyQuestionPartTwo;

import java.io.IOException;

/**
 * Created by chien on 19/04/2018.
 */
public class VerifyForPartTwoTest extends VerifyForListeningTest {

    private int sizeOfListQuestion = 30;
    private int sizeOfListSubQuestion = 1;
    private int sizeOfListSentence = 3;

    @Before
    public void init() throws IOException {
        super.init();
        this.verifyPartQuestion = new VerifyQuestionPartTwo(sizeOfListQuestion, sizeOfListSubQuestion, sizeOfListSentence);
    }
}
