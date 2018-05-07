package rio.it.Verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Model.QuestionModel;
import rio.it.App.Model.SubQuestionModel;
import rio.it.App.Transform.*;
import rio.it.App.Transform.impl.*;
import rio.it.App.Util.Impl.VerifyQuestionPartOne;
import rio.it.App.Util.VerifyPartQuestion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;

/**
 * Created by chien on 19/04/2018.
 */
public class VerifyForPartOneTest extends VerifyForListeningTest {

    private int maxSizeOfListQuestionModel = 10;
    private int maxSizeOfListFileImageModel = 1;
    private int minSizeOfListSubQuestionModel = 1;
    private int sizeOfListSentence = 4;

    @Before
    public void init() throws IOException {
        super.init();
    }

    @Override
    protected VerifyPartQuestion makeVerification() {
        return new VerifyQuestionPartOne(true, false, maxSizeOfListQuestionModel, minSizeOfListSubQuestionModel, minSizeOfListSubQuestionModel, sizeOfListSentence, maxSizeOfListFileImageModel);
    }

    private void makePartOne_WithDataNotFull() throws IOException {
        for (int i = 0; i < maxSizeOfListQuestionModel; i++) {
            QuestionModel questionModel = this.makeDataForInput.makeQuestionModel(true, false);
            for (int j = 0; j < maxSizeOfListFileImageModel; j++) {
                questionModel.getFileImageModelList().add(this.makeDataForInput.makeFileImageModel(false, false));
            }
            for (int j = 0; j < minSizeOfListSubQuestionModel; j++) {
                SubQuestionModel subQuestionModel = this.makeDataForInput.makeSubQuestionModel(true, true);
                questionModel.getSubQuestionModelList().add(subQuestionModel);
            }
            this.partQuestionModel.getQuestionModelList().add(questionModel);
        }
    }

    private void makePartOne_WithDataFull() throws IOException {
        this.makePartOne_WithDataNotFull();
        List<QuestionModel> questionModelList = this.partQuestionModel.getQuestionModelList();
        for (QuestionModel questionModel : questionModelList) {
            List<SubQuestionModel> subQuestionModelList = questionModel.getSubQuestionModelList();
            for (SubQuestionModel subQuestionModel : subQuestionModelList) {
                subQuestionModel.setSentenceModelList(new ArrayList<>());
                for (int i = 0; i < sizeOfListSentence; i++) {
                    subQuestionModel.getSentenceModelList().add(this.makeDataForInput.makeSentenceModel(false));
                }
            }
        }
    }

    @Test
    public void testPartOneWithDataNullMp3_False() throws IOException {
        // make error
        this.partQuestionModel.setPathFileMp3(this.makeDataForInput.makeFileMp3(true, false));
        Assert.assertNull(this.partQuestionModel.getPathFileMp3());
        Assert.assertFalse(this.verifyPartQuestion.verify(partQuestionModel));
    }

    @Test
    public void testPartOneWithDataEmptyMp3_False() throws IOException {
        // make error
        this.partQuestionModel.setPathFileMp3(this.makeDataForInput.makeFileMp3(false, true));
        Assert.assertTrue(this.partQuestionModel.getPathFileMp3().isEmpty());
        Assert.assertFalse(this.verifyPartQuestion.verify(partQuestionModel));
    }

    @Test
    public void testPartOneWithDataNullQuestion_False() {
        for (int i = 0; i < this.maxSizeOfListQuestionModel; i++) {
            // make error
            QuestionModel questionModel = null;
            this.partQuestionModel.getQuestionModelList().add(questionModel);
        }
        for (QuestionModel questionModel : this.partQuestionModel.getQuestionModelList()) {
            Assert.assertNull(questionModel);
        }
        Assert.assertFalse(this.partQuestionModel.getQuestionModelList().isEmpty());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testPartOneWithDataNullFileImage_False() throws IOException {
        this.makePartOne_WithDataNotFull();
        // make error
        this.partQuestionModel.getQuestionModelList().get(0)
                .getFileImageModelList().set(0, null);
        Assert.assertNull(this.partQuestionModel.getQuestionModelList().get(0).getFileImageModelList().get(0));
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testPartOneWithDataNullSubQuestion_False() throws IOException {
        this.makePartOne_WithDataNotFull();
        // make error
        this.partQuestionModel.getQuestionModelList().get(0)
                .getSubQuestionModelList().set(0, null);
        Assert.assertNull(this.partQuestionModel.getQuestionModelList().get(0).getSubQuestionModelList().get(0));
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testPartOneWithDataEmptyImage_False() throws IOException {
        this.makePartOne_WithDataNotFull();
        // make error
        this.partQuestionModel.getQuestionModelList().get(0)
                .getFileImageModelList().set(0, this.makeDataForInput.makeFileImageModel(false, true));
        Assert.assertEquals(0,
                this.partQuestionModel.getQuestionModelList().get(0)
                        .getFileImageModelList().get(0).getPathFileImage().getSize());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testPartOneRedundantSizeOfSentenceList_False() throws IOException {
        this.makePartOne_WithDataFull();
        // make error
        this.partQuestionModel.getQuestionModelList().get(0)
                .getSubQuestionModelList().get(0)
                .getSentenceModelList().add(this.makeDataForInput.makeSentenceModel(false));
        Assert.assertNotEquals(4, this.partQuestionModel.getQuestionModelList().get(0)
                .getSubQuestionModelList().get(0)
                .getSentenceModelList());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testPartOneRedundantParagraphList_False() throws IOException {
        this.makePartOne_WithDataNotFull();
        // make error
        QuestionModel questionModel = this.partQuestionModel.getQuestionModelList().get(0);
        questionModel.setParagraphModelList(new ArrayList<>());
        for (int i = 0; i < 2; i++) {
            questionModel.getParagraphModelList().add(this.makeDataForInput.makeParagraphModel(false));
        }
        Assert.assertThat(this.partQuestionModel.getQuestionModelList().get(0).getParagraphModelList(),
                is(not(emptyIterable())));
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testPartOneWithDataNotHaveAnswer_False() throws IOException {
        this.makePartOne_WithDataNotFull();
        //make error
        this.partQuestionModel.getQuestionModelList().get(0)
                .getSubQuestionModelList().get(0)
                .setAnswer(null);
        Assert.assertNull(this.partQuestionModel.getQuestionModelList().get(0)
                .getSubQuestionModelList().get(0).getAnswer());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testPartOneWithDataRedundantAskQuestion_False() throws IOException {
        this.makePartOne_WithDataNotFull();
        // make error
        this.partQuestionModel.getQuestionModelList().get(0)
                .getSubQuestionModelList().get(0)
                .setSentenceAsk("Ask Sentence");
        Assert.assertThat(this.partQuestionModel.getQuestionModelList().get(0)
                .getSubQuestionModelList().get(0)
                .getAnswer().toString(), is(not(isEmptyString())));
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testPartOneWithDataNotFull_True() throws IOException {
        this.makePartOne_WithDataNotFull();
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testPartOneWithDataFull_True() throws IOException {
        this.makePartOne_WithDataFull();
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionModel));
    }
}
