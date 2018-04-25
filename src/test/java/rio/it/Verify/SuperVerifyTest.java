package rio.it.Verify;

import org.junit.Assert;
import org.junit.Test;
import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Model.QuestionModel;
import rio.it.App.Model.SubQuestionModel;
import rio.it.App.Util.VerifyPartQuestion;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by chien on 19/04/2018.
 */
public abstract class SuperVerifyTest {

    protected MakeDataForInput makeDataForInput = new MakeDataForInput();
    protected VerifyPartQuestion verifyPartQuestion;
    protected PartQuestionModel partQuestionModel;

    protected void init() throws IOException {
        this.partQuestionModel = new PartQuestionModel();
        this.partQuestionModel.setNamePart("name part");
        this.partQuestionModel.setQuestionModelList(new ArrayList<>());
        this.verifyPartQuestion = this.makeVerification();
    }

    @Test
    public void testNull_ListQuestionModel_False() {
        this.partQuestionModel.setQuestionModelList(null);
        Assert.assertNull(this.partQuestionModel.getQuestionModelList());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testEmpty_ListQuestionModel_False() {
        this.partQuestionModel.setQuestionModelList(new ArrayList<>());
        Assert.assertNotNull(this.partQuestionModel.getQuestionModelList());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testNull_QuestionModel_False() {
        this.partQuestionModel.setQuestionModelList(new ArrayList<>());
        this.partQuestionModel.getQuestionModelList().add(null);
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testNull_ListSubQuestionModel_False() {
        this.partQuestionModel.setQuestionModelList(new ArrayList<>());
        this.partQuestionModel.getQuestionModelList().add(new QuestionModel());
        this.partQuestionModel.getQuestionModelList().get(0).setSubQuestionModelList(null);
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testEmpty_ListSubQuestionModel_False() {
        this.partQuestionModel.setQuestionModelList(new ArrayList<>());
        this.partQuestionModel.getQuestionModelList().add(new QuestionModel());
        this.partQuestionModel.getQuestionModelList().get(0).setSubQuestionModelList(new ArrayList<>());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testNull_SubQuestionModel_False() {
        this.partQuestionModel.setQuestionModelList(new ArrayList<>());
        this.partQuestionModel.getQuestionModelList().add(new QuestionModel());
        this.partQuestionModel.getQuestionModelList().get(0).setSubQuestionModelList(new ArrayList<>());
        this.partQuestionModel.getQuestionModelList().get(0).getSubQuestionModelList().add(null);
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testNull_ListSentenceModel_False() {
        this.partQuestionModel.setQuestionModelList(new ArrayList<>());
        this.partQuestionModel.getQuestionModelList().add(new QuestionModel());
        this.partQuestionModel.getQuestionModelList().get(0).setSubQuestionModelList(new ArrayList<>());
        this.partQuestionModel.getQuestionModelList().get(0).getSubQuestionModelList().add(new SubQuestionModel());
        this.partQuestionModel.getQuestionModelList().get(0).getSubQuestionModelList().get(0).setSentenceModelList(null);
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testEmpty_ListSentenceModel_False() {
        this.partQuestionModel.setQuestionModelList(new ArrayList<>());
        this.partQuestionModel.getQuestionModelList().add(new QuestionModel());
        this.partQuestionModel.getQuestionModelList().get(0).setSubQuestionModelList(new ArrayList<>());
        this.partQuestionModel.getQuestionModelList().get(0).getSubQuestionModelList().add(new SubQuestionModel());
        this.partQuestionModel.getQuestionModelList().get(0).getSubQuestionModelList().get(0).setSentenceModelList(new ArrayList<>());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    @Test
    public void testNull_SentenceModel_False() {
        this.partQuestionModel.setQuestionModelList(new ArrayList<>());
        this.partQuestionModel.getQuestionModelList().add(new QuestionModel());
        this.partQuestionModel.getQuestionModelList().get(0).setSubQuestionModelList(new ArrayList<>());
        this.partQuestionModel.getQuestionModelList().get(0).getSubQuestionModelList().add(new SubQuestionModel());
        this.partQuestionModel.getQuestionModelList().get(0).getSubQuestionModelList().get(0).setSentenceModelList(new ArrayList<>());
        this.partQuestionModel.getQuestionModelList().get(0).getSubQuestionModelList().get(0).getSentenceModelList().add(null);
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

    protected abstract VerifyPartQuestion makeVerification();

}
