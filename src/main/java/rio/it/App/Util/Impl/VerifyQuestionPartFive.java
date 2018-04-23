package rio.it.App.Util.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Dto.SentenceDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

import java.util.List;

/**
 * Created by chien on 12/04/2018.
 */
public class VerifyQuestionPartFive extends VerifyPartQuestionGeneric implements VerifyPartQuestion {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyQuestionPartFive.class);

    public VerifyQuestionPartFive(boolean allowNullListParagraphDto, boolean allowNullListFileImageDto, int maxSizeOfQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList) {
        super(allowNullListParagraphDto, allowNullListFileImageDto, maxSizeOfQuestionList, minSizeOfSubQuestionList, sizeOfSentenceList);
    }

    @Override
    protected void doLog() {
        LOGGER.info("Do verify for partQuestionDto part five");
    }

    @Override
    protected boolean verifyForFileMp3(MultipartFile multipartFile) {
        return this.verifyAllowNullFileMp3(multipartFile);
    }

    @Override
    protected boolean verifyForSubQuestionDto(SubQuestionDto subQuestionDto) {
        if (subQuestionDto != null
                && subQuestionDto.getAnswer() != null
                && this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getAnswer().toString())
                && !this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getSentenceAsk())) {
            List<SentenceDto> sentenceDtoList = subQuestionDto.getSentenceDtoList();
            if (this.verifyForSentenceDtoList(sentenceDtoList)) {
                return this.filterEachInSentenceDtoList(sentenceDtoList);
            }
        }
        return false;
    }
}
