package rio.it.Verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rio.it.App.Dto.*;
import rio.it.App.Util.Impl.VerifyQuestionPartOne;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by chien on 19/04/2018.
 */
public class VerifyForPartOneTest extends VerifyForListeningTest {

    private int sizeOfListQuestion = 10;
    private int sizeOfListFileImage = 1;
    private int sizeOfListSubQuestion = 1;
    private int sizeOfListSentence = 4;

    @Before
    public void init() throws IOException {
        super.init();
        this.verifyPartQuestion = new VerifyQuestionPartOne(sizeOfListQuestion, sizeOfListSubQuestion, sizeOfListSubQuestion, sizeOfListSentence, sizeOfListFileImage);
    }

    @Test
    public void testWithDataEmptyImage_False() throws IOException {
        for (int i = 0; i < sizeOfListQuestion; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(true, false);
            for (int j = 0; j < sizeOfListFileImage; j++) {
                // make error
                FileImageDto fileImageDto = this.makeDataForInput.makeFileImageDto(false, true);
                questionDto.getFileImageDtoList().add(fileImageDto);
            }
            for (int j = 0; j < sizeOfListSubQuestion; j++) {
                SubQuestionDto subQuestionDto = this.makeDataForInput.makeSubQuestionDto(true, true);
                questionDto.getSubQuestionDtoList().add(subQuestionDto);
            }
            this.partQuestionDto.getQuestionDtoList().add(questionDto);
        }
        for (QuestionDto questionDto : this.partQuestionDto.getQuestionDtoList()) {
            for (FileImageDto fileImageDto : questionDto.getFileImageDtoList()) {
                Assert.assertTrue(fileImageDto.getPathFileImage().isEmpty());
            }
        }
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testRedundantSizeOfSentenceList_False() throws IOException {
        for (int i = 0; i < sizeOfListQuestion; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(true, false);
            for (int j = 0; j < sizeOfListFileImage; j++) {
                questionDto.getFileImageDtoList().add(this.makeDataForInput.makeFileImageDto(false, false));
            }
            for (int j = 0; j < sizeOfListSubQuestion; j++) {
                SubQuestionDto subQuestionDto = this.makeDataForInput.makeSubQuestionDto(true, false);
                // make error
                for (int z = 0; z < 5; z++) {
                    subQuestionDto.getSentenceDtoList().add(this.makeDataForInput.makeSentenceDto(false));
                }
                questionDto.getSubQuestionDtoList().add(subQuestionDto);
            }
            this.partQuestionDto.getQuestionDtoList().add(questionDto);
        }
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testRedundantParagraphList_False() throws IOException {
        for (int i = 0; i < sizeOfListQuestion; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(false, false);
            for (int j = 0; j < sizeOfListFileImage; j++) {
                questionDto.getFileImageDtoList().add(this.makeDataForInput.makeFileImageDto(false, false));
            }
            // make error
            for (int j = 0; j < 2; j++) {
                questionDto.getParagraphDtoList().add(new ParagraphDto());
            }
            for (int j = 0; j < sizeOfListSubQuestion; j++) {
                SubQuestionDto subQuestionDto = this.makeDataForInput.makeSubQuestionDto(true, true);
                questionDto.getSubQuestionDtoList().add(subQuestionDto);
            }
            this.partQuestionDto.getQuestionDtoList().add(questionDto);
        }
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testWithDataNotFull_True() throws IOException {
        for (int i = 0; i < sizeOfListQuestion; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(true, false);
            for (int j = 0; j < sizeOfListFileImage; j++) {
                questionDto.getFileImageDtoList().add(this.makeDataForInput.makeFileImageDto(false, false));
            }
            for (int j = 0; j < sizeOfListSubQuestion; j++) {
                SubQuestionDto subQuestionDto = this.makeDataForInput.makeSubQuestionDto(true, true);
                questionDto.getSubQuestionDtoList().add(subQuestionDto);
            }
            this.partQuestionDto.getQuestionDtoList().add(questionDto);
        }
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testWithDataFull_True() throws IOException {
        for (int i = 0; i < sizeOfListQuestion; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(true, false);
            for (int j = 0; j < sizeOfListFileImage; j++) {
                questionDto.getFileImageDtoList().add(this.makeDataForInput.makeFileImageDto(false, false));
            }
            for (int j = 0; j < sizeOfListSubQuestion; j++) {
                SubQuestionDto subQuestionDto = this.makeDataForInput.makeSubQuestionDto(true, false);
                for (int z = 0; z < sizeOfListSentence; z++) {
                    subQuestionDto.getSentenceDtoList().add(this.makeDataForInput.makeSentenceDto(false));
                }
                questionDto.getSubQuestionDtoList().add(subQuestionDto);
            }
            this.partQuestionDto.getQuestionDtoList().add(questionDto);
        }
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionDto));
    }
}
