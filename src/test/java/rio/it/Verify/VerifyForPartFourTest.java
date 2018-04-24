package rio.it.Verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rio.it.App.Model.*;
import rio.it.App.Util.Impl.VerifyQuestionPartFour;
import rio.it.App.Util.VerifyPartQuestion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;

/**
 * Created by chien on 20/04/2018.
 */
public class VerifyForPartFourTest extends VerifyForListeningTest {

    private int maxSizeOfListQuestionModel = 10;
    private int maxSizeOfListSubQuestionModel = 3;
    private int sizeOfListSentence = 4;

    @Before
    public void init() throws IOException {
        super.init();
    }

    @Override
    protected VerifyPartQuestion makeVerification() {
        return new VerifyQuestionPartFour(this.maxSizeOfListQuestionModel, this.maxSizeOfListSubQuestionModel, this.sizeOfListSentence);
    }

    private void makePartFour_WithDataNotFull() {
        for (int i = 0; i < this.maxSizeOfListQuestionModel; i++) {
            QuestionModel questionModel = this.makeDataForInput.makeQuestionModel(true, true);
            for (int j = 0; j < this.maxSizeOfListSubQuestionModel; j++) {
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
    public void testPartFour_RedundantListFileImageModel_False() throws IOException {
        this.makePartFour_WithDataNotFull();
        List<QuestionModel> questionModelList = this.partQuestionModel.getQuestionModelList();
        for (QuestionModel questionModel : questionModelList) {
            // make error
            questionModel.setFileImageModelList(new ArrayList<>(1));
            FileImageModel fileImageModel = this.makeDataForInput.makeFileImageModel(false, true);
            questionModel.getFileImageModelList().add(fileImageModel);
        }
        Assert.assertNotNull(this.partQuestionModel.getQuestionModelList().get(0).getFileImageModelList());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testPartFourWithDataNotFull_Success() {
        this.makePartFour_WithDataNotFull();
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testPartFourWithDataFull_Success() {
        this.makePartFour_WithDataNotFull();
        List<QuestionModel> questionModelList = this.partQuestionModel.getQuestionModelList();
        for (QuestionModel questionModel : questionModelList) {
            questionModel.setParagraphModelList(new ArrayList<>());
            ParagraphModel paragraphModel = this.makeDataForInput.makeParagraphModel(false);
            questionModel.getParagraphModelList().add(paragraphModel);
        }
        Assert.assertNotNull(questionModelList.get(0).getParagraphModelList());
        Assert.assertNotNull(questionModelList.get(0).getParagraphModelList().get(0));
        Assert.assertThat(questionModelList.get(0).getParagraphModelList().get(0).getParagraph(), is(not(isEmptyOrNullString())));
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionModel));
    }
}
