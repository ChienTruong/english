package rio.it.Verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rio.it.App.Model.ParagraphModel;
import rio.it.App.Model.QuestionModel;
import rio.it.App.Model.SentenceModel;
import rio.it.App.Model.SubQuestionModel;
import rio.it.App.Util.Impl.VerifyQuestionPartFive;
import rio.it.App.Util.VerifyPartQuestion;

import java.io.IOException;

/**
 * Created by chien on 20/04/2018.
 */
public class VerifyForPartFiveTest extends SuperVerifyTest {

    private int maxSizeOfListQuestionModel = 40;
    private int minSizeOfListSubQuestionModel = 1;
    private int sizeOfListSentence = 4;

    @Before
    public void init() throws IOException {
        super.init();
    }

    @Override
    protected VerifyPartQuestion makeVerification() {
        return new VerifyQuestionPartFive(false, true, this.maxSizeOfListQuestionModel, this.minSizeOfListSubQuestionModel, this.sizeOfListSentence);
    }

    private void makeDataPartFive() {
        for (int i = 0; i < this.maxSizeOfListQuestionModel; i++) {
            QuestionModel questionModel = this.makeDataForInput.makeQuestionModel(false, true);
            ParagraphModel paragraphModel = this.makeDataForInput.makeParagraphModel(false);
            questionModel.getParagraphModelList().add(paragraphModel);
            for (int j = 0; j < this.minSizeOfListSubQuestionModel; j++) {
                SubQuestionModel subQuestionModel = this.makeDataForInput.makeSubQuestionModel(true, false);
                for (int z = 0; z < this.sizeOfListSentence; z++) {
                    SentenceModel sentenceModel = this.makeDataForInput.makeSentenceModel(false);
                    subQuestionModel.getSentenceModelList().add(sentenceModel);
                }
                questionModel.getSubQuestionModelList().add(subQuestionModel);
            }
            this.partQuestionModel.getQuestionModelList().add(questionModel);
        }
    }

    @Test
    public void testPartFiveWithData_Success() {
        this.makeDataPartFive();
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionModel));
    }
}
