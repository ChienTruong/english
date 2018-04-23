package rio.it.App.Util.Impl;

import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Dto.SentenceDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

import java.util.List;

/**
 * Created by chien on 12/04/2018.
 */
public class VerifyQuestionPartSix extends VerifyQuestionPartFive implements VerifyPartQuestion {

    public VerifyQuestionPartSix(boolean allowNullListParagraphDto, boolean allowNullListFileImageDto, int maxSizeOfQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList) {
        super(allowNullListParagraphDto, allowNullListFileImageDto, maxSizeOfQuestionList, minSizeOfSubQuestionList, sizeOfSentenceList);
    }

    @Override
    protected void doLog() {

    }

    @Override
    protected boolean verifyForFileMp3(MultipartFile multipartFile) {
        return this.verifyAllowNullFileMp3(multipartFile);
    }
}
