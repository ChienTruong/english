package rio.it.App.Util.Impl;

import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

/**
 * Created by chien on 12/04/2018.
 */
public class VerifyForPartSix extends VerifyPartQuestionGeneric implements VerifyPartQuestion {

    public VerifyForPartSix(int maxSizeOfQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList) {
        super(maxSizeOfQuestionList, minSizeOfSubQuestionList, sizeOfSentenceList);
    }

    @Override
    protected void doLog() {

    }

    @Override
    protected boolean verifyForFileMp3(MultipartFile multipartFile) {
        return this.verifyAllowNullFileMp3(multipartFile);
    }

    @Override
    protected boolean verifyForSubQuestionDto(SubQuestionDto subQuestionDto) {
        if (subQuestionDto.getAnswer() != null
                && this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getAnswer().toString())
                && !this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getSentenceAsk())) {
            if (this.verifyForSentenceDtoList(subQuestionDto.getSentenceDtoList())) {
                return true;
            }
        }
        return false;
    }
}
