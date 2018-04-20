package rio.it.Verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rio.it.App.Dto.ParagraphDto;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Dto.SentenceDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.Impl.VerifyQuestionPartFour;

import java.io.IOException;

/**
 * Created by chien on 20/04/2018.
 */
public class VerifyForPartFourTest extends VerifyForListeningTest {

    private int maxSizeOfListQuestionDto = 10;
    private int maxSizeOfListSubQuestionDto = 3;
    private int sizeOfListSentence = 4;

    @Before
    public void init() throws IOException {
        super.init();
        this.verifyPartQuestion = new VerifyQuestionPartFour(this.maxSizeOfListQuestionDto, this.maxSizeOfListSubQuestionDto, this.sizeOfListSentence);
    }

    @Test
    public void testPartFourWithDataNotFull_Success() {
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

    @Test
    public void testPartFourWithDataFull_Success() {
        for (int i = 0; i < this.maxSizeOfListQuestionDto; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(false, true);
            ParagraphDto paragraphDto = this.makeDataForInput.makeParagraphDto(false);
            questionDto.getParagraphDtoList().add(paragraphDto);
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
