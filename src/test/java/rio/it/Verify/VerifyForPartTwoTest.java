package rio.it.Verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rio.it.App.Dto.*;
import rio.it.App.Util.Impl.VerifyQuestionPartTwo;
import rio.it.App.Util.VerifyPartQuestion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

/**
 * Created by chien on 19/04/2018.
 */
public class VerifyForPartTwoTest extends VerifyForListeningTest {

    private int maxSizeOfListQuestionDto = 30;
    private int maxSizeOfListSubQuestionDto = 1;
    private int sizeOfListSentence = 3;

    @Before
    public void init() throws IOException {
        super.init();
    }

    @Override
    protected VerifyPartQuestion makeVerification() {
        return new VerifyQuestionPartTwo(true, true, maxSizeOfListQuestionDto, maxSizeOfListSubQuestionDto, sizeOfListSentence);
    }

    private void makePartTwo_WithDataNotFull() {
        for (int i = 0; i < this.maxSizeOfListQuestionDto; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(true, true);
            for (int j = 0; j < this.maxSizeOfListSubQuestionDto; j++) {
                SubQuestionDto subQuestionDto = this.makeDataForInput.makeSubQuestionDto(true, true);
                questionDto.getSubQuestionDtoList().add(subQuestionDto);
            }
            this.partQuestionDto.getQuestionDtoList().add(questionDto);
        }
    }

    @Test
    public void testPartTwo_RedundantListFileImageDto_False() throws IOException {
        this.makePartTwo_WithDataNotFull();
        List<QuestionDto> questionDtoList = this.partQuestionDto.getQuestionDtoList();
        for (QuestionDto questionDto : questionDtoList) {
            // make error
            questionDto.setFileImageDtoList(new ArrayList<>(0));
            FileImageDto fileImageDto = this.makeDataForInput.makeFileImageDto(false, false);
            questionDto.getFileImageDtoList().add(fileImageDto);
        }
        Assert.assertNotNull(this.partQuestionDto.getQuestionDtoList().get(0).getFileImageDtoList());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testPartTwo_RedundantListParagraphDto_False() {
        this.makePartTwo_WithDataNotFull();
        List<QuestionDto> questionDtoList = this.partQuestionDto.getQuestionDtoList();
        for (QuestionDto questionDto : questionDtoList) {
            // make error
            questionDto.setParagraphDtoList(new ArrayList<>(0));
            ParagraphDto paragraphDto = this.makeDataForInput.makeParagraphDto(false);
            questionDto.getParagraphDtoList().add(paragraphDto);
        }
        Assert.assertNotNull(this.partQuestionDto.getQuestionDtoList().get(0).getParagraphDtoList());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testPartTwo_NullAnswer_False() {
        this.makePartTwo_WithDataNotFull();
        List<QuestionDto> questionDtoList = this.partQuestionDto.getQuestionDtoList();
        for (QuestionDto questionDto : questionDtoList) {
            List<SubQuestionDto> subQuestionDtoList = questionDto.getSubQuestionDtoList();
            for (SubQuestionDto subQuestionDto : subQuestionDtoList) {
                // make error
                subQuestionDto.setAnswer(null);
            }
        }
        Assert.assertNull(this.partQuestionDto.getQuestionDtoList().get(0).getSubQuestionDtoList().get(0).getAnswer());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testPartTwo_RedundantSizeOfListQuestionDto_False() {
        this.makePartTwo_WithDataNotFull();
        // make error
        this.partQuestionDto.getQuestionDtoList().add(this.makeDataForInput.makeQuestionDto(true, true));
        Assert.assertEquals(this.maxSizeOfListQuestionDto + 1, this.partQuestionDto.getQuestionDtoList().size());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testPartTwo_RedundantSizeOfListSubQuestionDto_False() {
        this.makePartTwo_WithDataNotFull();
        List<QuestionDto> questionDtoList = this.partQuestionDto.getQuestionDtoList();
        for (QuestionDto questionDto : questionDtoList) {
            // make error
            questionDto.getSubQuestionDtoList().add(this.makeDataForInput.makeSubQuestionDto(true, true));
        }
        Assert.assertNotNull(this.partQuestionDto.getQuestionDtoList());
        Assert.assertEquals(this.maxSizeOfListSubQuestionDto + 1, questionDtoList.get(0).getSubQuestionDtoList().size());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testPartTwoWithDataNotFull_True() {
        this.makePartTwo_WithDataNotFull();
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testPartTwoWithDataFull_True() {
        this.makePartTwo_WithDataNotFull();
        List<QuestionDto> questionDtoList = this.partQuestionDto.getQuestionDtoList();
        for (QuestionDto questionDto : questionDtoList) {
            List<SubQuestionDto> subQuestionDtoList = questionDto.getSubQuestionDtoList();
            for (SubQuestionDto subQuestionDto : subQuestionDtoList) {
                subQuestionDto.setSentenceDtoList(new ArrayList<>());
                for (int z = 0; z < this.sizeOfListSentence; z++) {
                    SentenceDto sentenceDto = this.makeDataForInput.makeSentenceDto(false);
                    subQuestionDto.getSentenceDtoList().add(sentenceDto);
                }
            }
        }
        Assert.assertNotNull(this.partQuestionDto.getQuestionDtoList());
        Assert.assertNotNull(this.partQuestionDto.getQuestionDtoList().get(0).getSubQuestionDtoList().get(0).getSentenceDtoList());
        Assert.assertThat(
                this.partQuestionDto.getQuestionDtoList().get(0).getSubQuestionDtoList().get(0).getSentenceDtoList().get(0).getSentenceEn(),
                is(not(isEmptyOrNullString()))
        );
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionDto));
    }
}
