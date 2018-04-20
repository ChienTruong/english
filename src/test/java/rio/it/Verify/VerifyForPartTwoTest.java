package rio.it.Verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Dto.SentenceDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.Impl.VerifyQuestionPartTwo;

import java.io.IOException;

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
        this.verifyPartQuestion = new VerifyQuestionPartTwo(maxSizeOfListQuestionDto, maxSizeOfListSubQuestionDto, sizeOfListSentence);
    }

    @Test
    public void testPartTwoWithDataNotFull_True() {
        for (int i = 0; i < this.maxSizeOfListQuestionDto; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(true, true);
            for (int j = 0; j < this.maxSizeOfListSubQuestionDto; j++) {
                SubQuestionDto subQuestionDto = this.makeDataForInput.makeSubQuestionDto(true, true);
                questionDto.getSubQuestionDtoList().add(subQuestionDto);
            }
            this.partQuestionDto.getQuestionDtoList().add(questionDto);
        }
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testPartTwoWithDataFull_True() {
        for (int i = 0; i < this.maxSizeOfListQuestionDto; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(true, true);
            for (int j = 0; j < this.maxSizeOfListSubQuestionDto; j++) {
                SubQuestionDto subQuestionDto = this.makeDataForInput.makeSubQuestionDto(false, false);
                for (int z = 0; z < this.sizeOfListSentence; z++) {
                    SentenceDto sentenceDto = this.makeDataForInput.makeSentenceDto(false);
                    subQuestionDto.getSentenceDtoList().add(sentenceDto);
                }
                questionDto.getSubQuestionDtoList().add(subQuestionDto);
            }
            this.partQuestionDto.getQuestionDtoList().add(questionDto);
        }
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionDto));
    }
}
