package rio.it.Verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rio.it.App.Model.FileImageModel;
import rio.it.App.Model.QuestionModel;
import rio.it.App.Model.SentenceModel;
import rio.it.App.Model.SubQuestionModel;
import rio.it.App.Util.Impl.VerifyQuestionPartSeven;
import rio.it.App.Util.VerifyPartQuestion;

import java.io.IOException;

/**
 * Created by chien on 20/04/2018.
 */
public class VerifyForPartSevenTest extends SuperVerifyTest {

    private int maxSizeOfListQuestionModel = 14;
    private int maxSizeOfListSubQuestionModel = 5;
    private int minSizeOfListSubQuestionModel = 2;
    private int sizeOfListSentence = 4;
    private int maxSizeOfListFileImageModel = 2;

    @Before
    public void init() throws IOException {
        super.init();
    }

    @Override
    protected VerifyPartQuestion makeVerification() {
        return new VerifyQuestionPartSeven(true, false, this.maxSizeOfListQuestionModel, this.maxSizeOfListSubQuestionModel, this.minSizeOfListSubQuestionModel, this.sizeOfListSentence, this.maxSizeOfListFileImageModel);
    }

    private void makeDataPartSeven() throws IOException {
        for (int i = 0; i < this.maxSizeOfListQuestionModel; i++) {
            QuestionModel questionModel = this.makeDataForInput.makeQuestionModel(true, false);
            for (int j = 0; j < this.maxSizeOfListFileImageModel; j++) {
                FileImageModel fileImageModel = this.makeDataForInput.makeFileImageModel(false, false);
                questionModel.getFileImageModelList().add(fileImageModel);
            }
            for (int j = 0; j < this.minSizeOfListSubQuestionModel; j++) {
                SubQuestionModel subQuestionModel = this.makeDataForInput.makeSubQuestionModel(false, false);
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
    public void testPartSevenWithData_Success() throws IOException {
        this.makeDataPartSeven();
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionModel));
    }
}
