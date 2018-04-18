package rio.it.App.Util.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Dto.SentenceDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

import java.util.List;

/**
 * Created by chien on 12/04/2018.
 */
public class VerifyQuestionPartTwo extends VerifyPartQuestionGeneric implements VerifyPartQuestion {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyQuestionPartTwo.class);

    public VerifyQuestionPartTwo(int maxSizeOfQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList) {
        super(maxSizeOfQuestionList, minSizeOfSubQuestionList, sizeOfSentenceList);
    }

    @Override
    protected void doLog() {
        LOGGER.info("Do verify for partQuestionDto part two");
    }

    @Override
    protected boolean verifyForFileMp3(MultipartFile multipartFile) {
        return this.verifyNotAllowNullFileMp3(multipartFile);
    }

    @Override
    protected boolean verifyForQuestionDto(QuestionDto questionDto) {
        if (!this.functionVerify.verifyListNotNullAndNotEmpty(questionDto.getParagraphDtoList())
                && !this.functionVerify.verifyListNotNullAndNotEmpty(questionDto.getFileImageDtoList())
                && this.functionVerify.verifyListNotNullAndNotEmpty(questionDto.getSubQuestionDtoList())) {
            List<SubQuestionDto> subQuestionDtoList = questionDto.getSubQuestionDtoList();
            if (this.functionVerify.verifyListNotNullAndNotEmpty(subQuestionDtoList)
                    && subQuestionDtoList.size() <= this.maxSizeOfSubQuestionList
                    && subQuestionDtoList.size() >= this.minSizeOfSubQuestionList) {
                for (SubQuestionDto subQuestionDto : subQuestionDtoList) {
                    if (!this.verifyForSubQuestionDto(subQuestionDto)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean verifyForSubQuestionDto(SubQuestionDto subQuestionDto) {
        if (this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getAnswer().toString())) {
            if (this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getSentenceAsk())) {
                List<SentenceDto> sentenceDtoList = subQuestionDto.getSentenceDtoList();
                if (this.functionVerify.verifyListNotNullAndNotEmpty(sentenceDtoList)
                        && sentenceDtoList.size() == this.sizeOfSentenceList) {
                    for (SentenceDto sentenceDto : sentenceDtoList) {
                        if (!this.verifyForSentenceDto(sentenceDto)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return true;
        }
        return false;
    }
}
