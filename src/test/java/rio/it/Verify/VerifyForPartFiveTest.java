package rio.it.Verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rio.it.App.Dto.ParagraphDto;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Dto.SentenceDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.Impl.VerifyQuestionPartFive;
import rio.it.App.Util.VerifyPartQuestion;

import java.io.IOException;

/**
 * Created by chien on 20/04/2018.
 */
public class VerifyForPartFiveTest extends SuperVerifyTest {

    private int maxSizeOfListQuestionDto = 40;
    private int minSizeOfListSubQuestionDto = 1;
    private int sizeOfListSentence = 4;

    @Before
    public void init() throws IOException {
        super.init();
    }

    @Override
    protected VerifyPartQuestion makeVerification() {
        return new VerifyQuestionPartFive(false, true, this.maxSizeOfListQuestionDto, this.minSizeOfListSubQuestionDto, this.sizeOfListSentence);
    }

    private void makeDataPartFive() {
        for (int i = 0; i < this.maxSizeOfListQuestionDto; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(false, true);
            ParagraphDto paragraphDto = this.makeDataForInput.makeParagraphDto(false);
            questionDto.getParagraphDtoList().add(paragraphDto);
            for (int j = 0; j < this.minSizeOfListSubQuestionDto; j++) {
                SubQuestionDto subQuestionDto = this.makeDataForInput.makeSubQuestionDto(true, false);
                for (int z = 0; z < this.sizeOfListSentence; z++) {
                    SentenceDto sentenceDto = this.makeDataForInput.makeSentenceDto(false);
                    subQuestionDto.getSentenceDtoList().add(sentenceDto);
                }
                questionDto.getSubQuestionDtoList().add(subQuestionDto);
            }
            this.partQuestionDto.getQuestionDtoList().add(questionDto);
        }
    }

    @Test
    public void testPartFiveWithData_Success() {
        this.makeDataPartFive();
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionDto));
    }
}
