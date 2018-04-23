package rio.it.Verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rio.it.App.Dto.FileImageDto;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Dto.SentenceDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.Impl.VerifyQuestionPartSeven;
import rio.it.App.Util.VerifyPartQuestion;

import java.io.IOException;

/**
 * Created by chien on 20/04/2018.
 */
public class VerifyForPartSevenTest extends SuperVerifyTest {

    private int maxSizeOfListQuestionDto = 14;
    private int maxSizeOfListSubQuestionDto = 5;
    private int minSizeOfListSubQuestionDto = 2;
    private int sizeOfListSentence = 4;
    private int maxSizeOfListFileImageDto = 2;

    @Before
    public void init() throws IOException {
        super.init();
    }

    @Override
    protected VerifyPartQuestion makeVerification() {
        return new VerifyQuestionPartSeven(true, false, this.maxSizeOfListQuestionDto, this.maxSizeOfListSubQuestionDto, this.minSizeOfListSubQuestionDto, this.sizeOfListSentence, this.maxSizeOfListFileImageDto);
    }

    private void makeDataPartSeven() throws IOException {
        for (int i = 0; i < this.maxSizeOfListQuestionDto; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(true, false);
            for (int j = 0; j < this.maxSizeOfListFileImageDto; j++) {
                FileImageDto fileImageDto = this.makeDataForInput.makeFileImageDto(false, false);
                questionDto.getFileImageDtoList().add(fileImageDto);
            }
            for (int j = 0; j < this.minSizeOfListSubQuestionDto; j++) {
                SubQuestionDto subQuestionDto = this.makeDataForInput.makeSubQuestionDto(false, false);
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
    public void testPartSevenWithData_Success() throws IOException {
        this.makeDataPartSeven();
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionDto));
    }
}
