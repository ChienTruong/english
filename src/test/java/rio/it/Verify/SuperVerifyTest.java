package rio.it.Verify;

import org.junit.Assert;
import org.junit.Test;
import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by chien on 19/04/2018.
 */
public abstract class SuperVerifyTest {

    protected MakeDataForInput makeDataForInput = new MakeDataForInput();
    protected VerifyPartQuestion verifyPartQuestion;
    protected PartQuestionDto partQuestionDto;

    protected void init() throws IOException {
        this.partQuestionDto = new PartQuestionDto();
        this.partQuestionDto.setNamePart("name part");
        this.partQuestionDto.setQuestionDtoList(new ArrayList<>());
        this.verifyPartQuestion = this.makeVerification();
    }

    @Test
    public void testNull_ListQuestionDto_False() {
        this.partQuestionDto.setQuestionDtoList(null);
        Assert.assertNull(this.partQuestionDto.getQuestionDtoList());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testEmpty_ListQuestionDto_False() {
        this.partQuestionDto.setQuestionDtoList(new ArrayList<>());
        Assert.assertNotNull(this.partQuestionDto.getQuestionDtoList());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testNull_QuestionDto_False() {
        this.partQuestionDto.setQuestionDtoList(new ArrayList<>());
        this.partQuestionDto.getQuestionDtoList().add(null);
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testNull_ListSubQuestionDto_False() {
        this.partQuestionDto.setQuestionDtoList(new ArrayList<>());
        this.partQuestionDto.getQuestionDtoList().add(new QuestionDto());
        this.partQuestionDto.getQuestionDtoList().get(0).setSubQuestionDtoList(null);
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testEmpty_ListSubQuestionDto_False() {
        this.partQuestionDto.setQuestionDtoList(new ArrayList<>());
        this.partQuestionDto.getQuestionDtoList().add(new QuestionDto());
        this.partQuestionDto.getQuestionDtoList().get(0).setSubQuestionDtoList(new ArrayList<>());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testNull_SubQuestionDto_False() {
        this.partQuestionDto.setQuestionDtoList(new ArrayList<>());
        this.partQuestionDto.getQuestionDtoList().add(new QuestionDto());
        this.partQuestionDto.getQuestionDtoList().get(0).setSubQuestionDtoList(new ArrayList<>());
        this.partQuestionDto.getQuestionDtoList().get(0).getSubQuestionDtoList().add(null);
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testNull_ListSentenceDto_False() {
        this.partQuestionDto.setQuestionDtoList(new ArrayList<>());
        this.partQuestionDto.getQuestionDtoList().add(new QuestionDto());
        this.partQuestionDto.getQuestionDtoList().get(0).setSubQuestionDtoList(new ArrayList<>());
        this.partQuestionDto.getQuestionDtoList().get(0).getSubQuestionDtoList().add(new SubQuestionDto());
        this.partQuestionDto.getQuestionDtoList().get(0).getSubQuestionDtoList().get(0).setSentenceDtoList(null);
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testEmpty_ListSentenceDto_False() {
        this.partQuestionDto.setQuestionDtoList(new ArrayList<>());
        this.partQuestionDto.getQuestionDtoList().add(new QuestionDto());
        this.partQuestionDto.getQuestionDtoList().get(0).setSubQuestionDtoList(new ArrayList<>());
        this.partQuestionDto.getQuestionDtoList().get(0).getSubQuestionDtoList().add(new SubQuestionDto());
        this.partQuestionDto.getQuestionDtoList().get(0).getSubQuestionDtoList().get(0).setSentenceDtoList(new ArrayList<>());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testNull_SentenceDto_False() {
        this.partQuestionDto.setQuestionDtoList(new ArrayList<>());
        this.partQuestionDto.getQuestionDtoList().add(new QuestionDto());
        this.partQuestionDto.getQuestionDtoList().get(0).setSubQuestionDtoList(new ArrayList<>());
        this.partQuestionDto.getQuestionDtoList().get(0).getSubQuestionDtoList().add(new SubQuestionDto());
        this.partQuestionDto.getQuestionDtoList().get(0).getSubQuestionDtoList().get(0).setSentenceDtoList(new ArrayList<>());
        this.partQuestionDto.getQuestionDtoList().get(0).getSubQuestionDtoList().get(0).getSentenceDtoList().add(null);
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    protected abstract VerifyPartQuestion makeVerification();

}
