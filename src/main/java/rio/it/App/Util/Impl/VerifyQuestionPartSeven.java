package rio.it.App.Util.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Dto.FileImageDto;
import rio.it.App.Dto.ParagraphDto;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

import java.util.List;

/**
 * Created by chien on 12/04/2018.
 */
public class VerifyQuestionPartSeven extends VerifyPartQuestionGeneric implements VerifyPartQuestion {

    private Logger logger = LoggerFactory.getLogger(VerifyQuestionPartSeven.class);

    public VerifyQuestionPartSeven(boolean allowNullListParagraphDto, boolean allowNullListFileImageDto, int maxSizeOfQuestionList, int maxSizeOfSubQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList, int sizeOfFileImageList) {
        super(allowNullListParagraphDto, allowNullListFileImageDto, maxSizeOfQuestionList, maxSizeOfSubQuestionList, minSizeOfSubQuestionList, sizeOfSentenceList, sizeOfFileImageList);
    }


    @Override
    protected void doLog() {

    }

    @Override
    protected boolean verifyForFileMp3(MultipartFile multipartFile) {
        return this.verifyAllowNullFileMp3(multipartFile);
    }

}
