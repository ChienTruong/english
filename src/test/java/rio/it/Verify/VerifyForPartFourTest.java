package rio.it.Verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rio.it.App.Dto.*;
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

    private int maxSizeOfListQuestionDto = 10;
    private int maxSizeOfListSubQuestionDto = 3;
    private int sizeOfListSentence = 4;

    @Before
    public void init() throws IOException {
        super.init();
    }

    @Override
    protected VerifyPartQuestion makeVerification() {
        return new VerifyQuestionPartFour(this.maxSizeOfListQuestionDto, this.maxSizeOfListSubQuestionDto, this.sizeOfListSentence);
    }

    private void makePartFour_WithDataNotFull() {
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
    }

    @Test
    public void testPartFour_RedundantListFileImageDto_False() throws IOException {
        this.makePartFour_WithDataNotFull();
        List<QuestionDto> questionDtoList = this.partQuestionDto.getQuestionDtoList();
        for (QuestionDto questionDto : questionDtoList) {
            // make error
            questionDto.setFileImageDtoList(new ArrayList<>(1));
            FileImageDto fileImageDto = this.makeDataForInput.makeFileImageDto(false, true);
            questionDto.getFileImageDtoList().add(fileImageDto);
        }
        Assert.assertNotNull(this.partQuestionDto.getQuestionDtoList().get(0).getFileImageDtoList());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testPartFourWithDataNotFull_Success() {
        this.makePartFour_WithDataNotFull();
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testPartFourWithDataFull_Success() {
        this.makePartFour_WithDataNotFull();
        List<QuestionDto> questionDtoList = this.partQuestionDto.getQuestionDtoList();
        for (QuestionDto questionDto : questionDtoList) {
            questionDto.setParagraphDtoList(new ArrayList<>());
            ParagraphDto paragraphDto = this.makeDataForInput.makeParagraphDto(false);
            questionDto.getParagraphDtoList().add(paragraphDto);
        }
        Assert.assertNotNull(questionDtoList.get(0).getParagraphDtoList());
        Assert.assertNotNull(questionDtoList.get(0).getParagraphDtoList().get(0));
        Assert.assertThat(questionDtoList.get(0).getParagraphDtoList().get(0).getParagraph(), is(not(isEmptyOrNullString())));
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionDto));
    }
}
