package rio.it.App.Util.Impl;

import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

/**
 * Created by chien on 12/04/2018.
 */
public class VerifyQuestionPartFour extends VerifyPartQuestionGeneric implements VerifyPartQuestion {

    public VerifyQuestionPartFour(int maxSizeOfQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList) {
        super(maxSizeOfQuestionList, minSizeOfSubQuestionList, sizeOfSentenceList);
    }

    @Override
    protected void doLog() {

    }

    @Override
    protected boolean verifyForFileMp3(MultipartFile multipartFile) {
        return this.verifyNotAllowNullFileMp3(multipartFile);
    }

    @Override
    protected boolean verifyForQuestionDto(QuestionDto questionDto) {
        return false;
    }

    @Override
    protected boolean verifyForSubQuestionDto(SubQuestionDto subQuestionDto) {
        return false;
    }
}
