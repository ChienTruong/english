package rio.it.App.Util.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Dto.FileImageDto;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Dto.SentenceDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

import java.util.List;


/**
 * Created by chien on 12/04/2018.
 */
public class VerifyQuestionPartOne extends VerifyPartQuestionGeneric implements VerifyPartQuestion {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyQuestionPartOne.class);

    public VerifyQuestionPartOne(boolean allowNullListParagraphDto, boolean allowNullListFileImageDto, int maxSizeOfQuestionList, int maxSizeOfSubQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList, int sizeOfFileImageList) {
        super(allowNullListParagraphDto, allowNullListFileImageDto, maxSizeOfQuestionList, maxSizeOfSubQuestionList, minSizeOfSubQuestionList, sizeOfSentenceList, sizeOfFileImageList);
    }

    @Override
    protected void doLog() {
    }

    @Override
    protected boolean verifyForFileMp3(MultipartFile multipartFile) {
        return this.verifyNotAllowNullFileMp3(multipartFile);
    }

    @Override
    protected boolean verifyForSubQuestionDto(SubQuestionDto subQuestionDto) {
        if (subQuestionDto != null
                && subQuestionDto.getAnswer() != null
                && this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getAnswer().toString())
                && !this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getSentenceAsk())) {
            List<SentenceDto> sentenceDtoList = subQuestionDto.getSentenceDtoList();
            if (this.functionVerify.verifyListNotNullAndNotEmpty(sentenceDtoList)) {
                if (sentenceDtoList.size() != this.sizeOfSentenceList) {
                    return false;
                }
                return this.filterEachInSentenceDtoList(sentenceDtoList);
            } else {
                return true;
            }
        }
        return false;
    }
}
