package rio.it.Verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rio.it.App.Dto.FileImageDto;
import rio.it.App.Dto.ParagraphDto;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.Impl.VerifyQuestionPartOne;
import rio.it.App.Util.VerifyPartQuestion;

import java.io.IOException;

/**
 * Created by chien on 19/04/2018.
 */
public class VerifyForPartOneTest extends VerifyForListeningTest {

    private int maxSizeOfListQuestionDto = 10;
    private int maxSizeOfListFileImageDto = 1;
    private int minSizeOfListSubQuestionDto = 1;
    private int sizeOfListSentence = 4;

    @Before
    public void init() throws IOException {
        super.init();
    }

    @Override
    protected VerifyPartQuestion makeVerification() {
        return new VerifyQuestionPartOne(true, false, maxSizeOfListQuestionDto, minSizeOfListSubQuestionDto, minSizeOfListSubQuestionDto, sizeOfListSentence, maxSizeOfListFileImageDto);
    }

    @Test
    public void testPartOneWithDataNullMp3_False() throws IOException {
        // make error
        this.partQuestionDto.setPathFileMp3(this.makeDataForInput.makeFileMp3(true, false));
        Assert.assertNull(this.partQuestionDto.getPathFileMp3());
        Assert.assertFalse(this.verifyPartQuestion.verify(partQuestionDto));
    }

    @Test
    public void testPartOneWithDataEmptyMp3_False() throws IOException {
        // make error
        this.partQuestionDto.setPathFileMp3(this.makeDataForInput.makeFileMp3(false, true));
        Assert.assertTrue(this.partQuestionDto.getPathFileMp3().isEmpty());
        Assert.assertFalse(this.verifyPartQuestion.verify(partQuestionDto));
    }

    @Test
    public void testPartOneWithDataNullQuestion_False() {
        for (int i = 0; i < this.maxSizeOfListQuestionDto; i++) {
            // make error
            QuestionDto questionDto = null;
            this.partQuestionDto.getQuestionDtoList().add(questionDto);
        }
        for (QuestionDto questionDto : this.partQuestionDto.getQuestionDtoList()) {
            Assert.assertNull(questionDto);
        }
        Assert.assertFalse(this.partQuestionDto.getQuestionDtoList().isEmpty());
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testPartOneWithDataNullFileImage_False() {
        for (int i = 0; i < this.maxSizeOfListQuestionDto; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(true, false);
            for (int j = 0; j < this.maxSizeOfListFileImageDto; j++) {
                // make error
                FileImageDto fileImageDto = null;
                questionDto.getFileImageDtoList().add(fileImageDto);
            }
            this.partQuestionDto.getQuestionDtoList().add(questionDto);
        }
        for (QuestionDto questionDto : this.partQuestionDto.getQuestionDtoList()) {
            Assert.assertNotNull(questionDto);
            for (FileImageDto fileImageDto : questionDto.getFileImageDtoList()) {
                Assert.assertNull(fileImageDto);
            }
        }
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testPartOneWithDataNullSubQuestion_False() throws IOException {
        for (int i = 0; i < maxSizeOfListQuestionDto; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(true, false);
            for (int j = 0; j < maxSizeOfListFileImageDto; j++) {
                questionDto.getFileImageDtoList().add(this.makeDataForInput.makeFileImageDto(false, false));
            }
            for (int j = 0; j < minSizeOfListSubQuestionDto; j++) {
                SubQuestionDto subQuestionDto = null;
                questionDto.getSubQuestionDtoList().add(subQuestionDto);
            }
            this.partQuestionDto.getQuestionDtoList().add(questionDto);
        }
        for (QuestionDto questionDto : this.partQuestionDto.getQuestionDtoList()) {
            Assert.assertNotNull(questionDto);
            for (FileImageDto fileImageDto : questionDto.getFileImageDtoList()) {
                Assert.assertNotNull(fileImageDto);
            }
            for (SubQuestionDto subQuestionDto : questionDto.getSubQuestionDtoList()) {
                Assert.assertNull(subQuestionDto);
            }
        }
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testPartOneWithDataEmptyImage_False() throws IOException {
        for (int i = 0; i < maxSizeOfListQuestionDto; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(true, false);
            for (int j = 0; j < maxSizeOfListFileImageDto; j++) {
                // make error
                FileImageDto fileImageDto = this.makeDataForInput.makeFileImageDto(false, true);
                questionDto.getFileImageDtoList().add(fileImageDto);
            }
            for (int j = 0; j < minSizeOfListSubQuestionDto; j++) {
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
    public void testPartOneRedundantSizeOfSentenceList_False() throws IOException {
        for (int i = 0; i < maxSizeOfListQuestionDto; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(true, false);
            for (int j = 0; j < maxSizeOfListFileImageDto; j++) {
                questionDto.getFileImageDtoList().add(this.makeDataForInput.makeFileImageDto(false, false));
            }
            for (int j = 0; j < minSizeOfListSubQuestionDto; j++) {
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
    public void testPartOneRedundantParagraphList_False() throws IOException {
        for (int i = 0; i < maxSizeOfListQuestionDto; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(false, false);
            for (int j = 0; j < maxSizeOfListFileImageDto; j++) {
                questionDto.getFileImageDtoList().add(this.makeDataForInput.makeFileImageDto(false, false));
            }
            // make error
            for (int j = 0; j < 2; j++) {
                questionDto.getParagraphDtoList().add(new ParagraphDto());
            }
            for (int j = 0; j < minSizeOfListSubQuestionDto; j++) {
                SubQuestionDto subQuestionDto = this.makeDataForInput.makeSubQuestionDto(true, true);
                questionDto.getSubQuestionDtoList().add(subQuestionDto);
            }
            this.partQuestionDto.getQuestionDtoList().add(questionDto);
        }
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testPartOneWithDataNotHaveAnswer_False() throws IOException {
        for (int i = 0; i < maxSizeOfListQuestionDto; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(true, false);
            for (int j = 0; j < maxSizeOfListFileImageDto; j++) {
                questionDto.getFileImageDtoList().add(this.makeDataForInput.makeFileImageDto(false, false));
            }
            for (int j = 0; j < minSizeOfListSubQuestionDto; j++) {
                SubQuestionDto subQuestionDto = this.makeDataForInput.makeSubQuestionDto(true, true);
                // make error
                subQuestionDto.setAnswer(null);
                questionDto.getSubQuestionDtoList().add(subQuestionDto);
            }
            this.partQuestionDto.getQuestionDtoList().add(questionDto);
        }
        Assert.assertFalse(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testPartOneWithDataNotFull_True() throws IOException {
        for (int i = 0; i < maxSizeOfListQuestionDto; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(true, false);
            for (int j = 0; j < maxSizeOfListFileImageDto; j++) {
                questionDto.getFileImageDtoList().add(this.makeDataForInput.makeFileImageDto(false, false));
            }
            for (int j = 0; j < minSizeOfListSubQuestionDto; j++) {
                SubQuestionDto subQuestionDto = this.makeDataForInput.makeSubQuestionDto(true, true);
                questionDto.getSubQuestionDtoList().add(subQuestionDto);
            }
            this.partQuestionDto.getQuestionDtoList().add(questionDto);
        }
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionDto));
    }

    @Test
    public void testPartOneWithDataFull_True() throws IOException {
        for (int i = 0; i < maxSizeOfListQuestionDto; i++) {
            QuestionDto questionDto = this.makeDataForInput.makeQuestionDto(true, false);
            for (int j = 0; j < maxSizeOfListFileImageDto; j++) {
                questionDto.getFileImageDtoList().add(this.makeDataForInput.makeFileImageDto(false, false));
            }
            for (int j = 0; j < minSizeOfListSubQuestionDto; j++) {
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
