package rio.it.Verify;

import org.junit.Before;
import rio.it.App.Util.Impl.VerifyForPartSix;

import java.io.IOException;

/**
 * Created by chien on 20/04/2018.
 */
public class VerifyForPartSixTest extends SuperVerifyTest {

    private int maxSizeOfListQuestionDto = 4;
    private int minSizeOfListSubQuestionDto = 3;
    private int sizeOfListSentence = 4;

    @Before
    public void init() throws IOException {
        super.init();
        this.verifyPartQuestion = new VerifyForPartSix(this.maxSizeOfListQuestionDto, this.minSizeOfListSubQuestionDto, this.sizeOfListSentence);
    }
}
