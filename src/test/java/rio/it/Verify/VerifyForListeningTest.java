package rio.it.Verify;

import org.junit.Assert;
import org.junit.Test;
import rio.it.App.Dto.PartQuestionDto;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by chien on 19/04/2018.
 */
public class VerifyForListeningTest extends SuperVerifyTest {

    protected void init() throws IOException {
        this.partQuestionDto = new PartQuestionDto();
        this.partQuestionDto.setNamePart("name part");
        this.partQuestionDto.setQuestionDtoList(new ArrayList<>());
        this.partQuestionDto.setPathFileMp3(this.makeDataForInput.makeFileMp3(false, false));
    }

    @Test
    public void testWithDataNullMp3_False() throws IOException {
        // make error
        this.partQuestionDto.setPathFileMp3(this.makeDataForInput.makeFileMp3(true, false));
        Assert.assertNull(this.partQuestionDto.getPathFileMp3());
        Assert.assertFalse(this.verifyPartQuestion.verify(partQuestionDto));
    }

    @Test
    public void testWithDataEmptyMp3_False() throws IOException {
        // make error
        this.partQuestionDto.setPathFileMp3(this.makeDataForInput.makeFileMp3(false, true));
        Assert.assertTrue(this.partQuestionDto.getPathFileMp3().isEmpty());
        Assert.assertFalse(this.verifyPartQuestion.verify(partQuestionDto));
    }
}
