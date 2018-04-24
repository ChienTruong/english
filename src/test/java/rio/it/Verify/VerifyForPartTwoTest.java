package rio.it.Verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rio.it.App.Model.*;
import rio.it.App.Util.Impl.VerifyQuestionPartTwo;
import rio.it.App.Util.VerifyPartQuestion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;

/**
 * Created by chien on 19/04/2018.
 */
public class VerifyForPartTwoTest extends VerifyForListeningTest {

    private int maxSizeOfListQuestionModel = 30;
    private int maxSizeOfListSubQuestionModel = 1;
    private int sizeOfListSentence = 3;

    @Before
    public void init() throws IOException {
        super.init();
    }

    @Override
    protected VerifyPartQuestion makeVerification() {
        return new VerifyQuestionPartTwo(true, true, maxSizeOfListQuestionModel, maxSizeOfListSubQuestionModel, sizeOfListSentence);
    }

    private void makePartTwo_WithDataNotFull() {
        for (int i = 0; i < this.maxSizeOfListQuestionModel; i++) {
            QuestionModel questionModel = this.makeDataForInput.makeQuestionModel(true, true);
            for (int j = 0; j < this.maxSizeOfListSubQuestionModel; j++) {
                SubQuestionModel subQuestionModel = this.makeDataForInput.makeSubQuestionModel(true, true);
                questionModel.getSubQuestionModelList().add(subQuestionModel);
            }
            this.partQuestionModel.getQuestionModelList().add(questionModel);
        }
    }

    private void makePartTwo_WithDataFull() {
        this.makePartTwo_WithDataNotFull();
        List<QuestionModel> questionModelList = this.partQuestionModel.getQuestionModelList();
        for (QuestionModel questionModel : questionModelList) {
            List<SubQuestionModel> subQuestionModelList = questionModel.getSubQuestionModelList();
            for (SubQuestionModel subQuestionModel : subQuestionModelList) {
                subQuestionModel.setSentenceModelList(new ArrayList<>());
                for (int z = 0; z < this.sizeOfListSentence; z++) {
                    SentenceModel sentenceModel = this.makeDataForInput.makeSentenceModel(false);
                    subQuestionModel.getSentenceModelList().add(sentenceModel);
                }
            }
        }
    }

    @Test
    public void testPartTwo_RedundantListFileImageModel_False() throws IOException {
        this.makePartTwo_WithDataNotFull();
        List<QuestionModel> questionModelList = this.partQuestionModel.getQuestionModelList();
        for (QuestionModel questionModel : questionModelList) {
            // make error
            questionModel.setFileImageModelList(new ArrayList<>(0));
            FileImageModel fileImageModel = this.makeDataForInput.makeFileImageModel(false, false);
            questionModel.getFileImageModelList().add(fileImageModel);
        }
        Assert.assertNotNull(this.partQuestionModel.getQuestionModelList().get(0).getFileImageModelList());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testPartTwo_RedundantListParagraphModel_False() {
        this.makePartTwo_WithDataNotFull();
        List<QuestionModel> questionModelList = this.partQuestionModel.getQuestionModelList();
        for (QuestionModel questionModel : questionModelList) {
            // make error
            questionModel.setParagraphModelList(new ArrayList<>(0));
            ParagraphModel paragraphModel = this.makeDataForInput.makeParagraphModel(false);
            questionModel.getParagraphModelList().add(paragraphModel);
        }
        Assert.assertNotNull(this.partQuestionModel.getQuestionModelList().get(0).getParagraphModelList());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testPartTwo_NullAnswer_False() {
        this.makePartTwo_WithDataNotFull();
        List<QuestionModel> questionModelList = this.partQuestionModel.getQuestionModelList();
        for (QuestionModel questionModel : questionModelList) {
            List<SubQuestionModel> subQuestionModelList = questionModel.getSubQuestionModelList();
            for (SubQuestionModel subQuestionModel : subQuestionModelList) {
                // make error
                subQuestionModel.setAnswer(null);
            }
        }
        Assert.assertNull(this.partQuestionModel.getQuestionModelList().get(0).getSubQuestionModelList().get(0).getAnswer());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testPartTwo_RedundantSizeOfListQuestionModel_False() {
        this.makePartTwo_WithDataNotFull();
        // make error
        this.partQuestionModel.getQuestionModelList().add(this.makeDataForInput.makeQuestionModel(true, true));
        Assert.assertEquals(this.maxSizeOfListQuestionModel + 1, this.partQuestionModel.getQuestionModelList().size());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testPartTwo_RedundantSizeOfListSubQuestionModel_False() {
        this.makePartTwo_WithDataNotFull();
        List<QuestionModel> questionModelList = this.partQuestionModel.getQuestionModelList();
        for (QuestionModel questionModel : questionModelList) {
            // make error
            questionModel.getSubQuestionModelList().add(this.makeDataForInput.makeSubQuestionModel(true, true));
        }
        Assert.assertNotNull(this.partQuestionModel.getQuestionModelList());
        Assert.assertEquals(this.maxSizeOfListSubQuestionModel + 1, questionModelList.get(0).getSubQuestionModelList().size());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testPartTwoWithDataNotFull_True() {
        this.makePartTwo_WithDataNotFull();
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testPartTwoWithDataFull_True() {
        this.makePartTwo_WithDataFull();
        Assert.assertNotNull(this.partQuestionModel.getQuestionModelList());
        Assert.assertNotNull(this.partQuestionModel.getQuestionModelList().get(0).getSubQuestionModelList().get(0).getSentenceModelList());
        Assert.assertThat(
                this.partQuestionModel.getQuestionModelList().get(0).getSubQuestionModelList().get(0).getSentenceModelList().get(0).getSentenceEn(),
                is(not(isEmptyOrNullString()))
        );
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionModel));
    }
}
