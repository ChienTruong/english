package rio.it.App.Util.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rio.it.App.Dto.PartQuestionDto;
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

    public VerifyQuestionPartTwo(int maxSizeOfQuestionList, int maxSizeOfSubQuestionList, int maxSizeOfSentenceList) {
        super(maxSizeOfQuestionList, maxSizeOfSubQuestionList, maxSizeOfSentenceList);
    }

    @Override
    protected boolean doVerify(PartQuestionDto partQuestionDto) {
        LOGGER.info("Do verify for partQuestionDto part two");
        return verifyItDoNotRedundant(partQuestionDto);
    }

    /**
     * @param partQuestionDto
     * @return
     */
    private boolean verifyItDoNotRedundant(PartQuestionDto partQuestionDto) {
        if (partQuestionDto != null) {
            if (functionVerify.verifyNamePart(partQuestionDto.getNamePart())) {
                if (!functionVerify.verifyFileNull(partQuestionDto.getPathFileMp3())) {
                    if (functionVerify.verifySuffixOfFile(partQuestionDto.getPathFileMp3(), this.suffixMp3)
                            && functionVerify.verifySizeOfFile(partQuestionDto.getPathFileMp3())) {
                        List<QuestionDto> questionDtoList = partQuestionDto.getQuestionDtoList();
                        if (functionVerify.verifyListNotNullAndNotEmpty(questionDtoList)
                                && questionDtoList.size() <= this.maxSizeOfQuestionList) {
                            for (QuestionDto questionDto : questionDtoList) {
                                if (!verifyForQuestionDto(questionDto)) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean verifyForQuestionDto(QuestionDto questionDto) {
        if (!functionVerify.verifyListNotNullAndNotEmpty(questionDto.getParagraphDtoList())
                && !functionVerify.verifyListNotNullAndNotEmpty(questionDto.getFileImageDtoList())
                && functionVerify.verifyListNotNullAndNotEmpty(questionDto.getSubQuestionDtoList())) {
            List<SubQuestionDto> subQuestionDtoList = questionDto.getSubQuestionDtoList();
            if (functionVerify.verifyListNotNullAndNotEmpty(subQuestionDtoList)
                    && subQuestionDtoList.size() == this.maxSizeOfSubQuestionList) {
                for (SubQuestionDto subQuestionDto : subQuestionDtoList) {
                    if (!verifyForSubQuestion(subQuestionDto)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private boolean verifyForSubQuestion(SubQuestionDto subQuestionDto) {
        if (functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getAnswer().toString())) {
            if (functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getSentenceAsk())) {
                List<SentenceDto> sentenceDtoList = subQuestionDto.getSentenceDtoList();
                if (functionVerify.verifyListNotNullAndNotEmpty(sentenceDtoList)
                        && sentenceDtoList.size() == this.maxSizeOfSentenceList) {
                    for (SentenceDto sentenceDto : sentenceDtoList) {
                        if (!verifyForSentenceDto(sentenceDto)) {
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

    private boolean verifyForSentenceDto(SentenceDto sentenceDto) {
        if (functionVerify.verifyStringNotNullAndNoEmpty(sentenceDto.getSentenceEn())) {
            return true;
        }
        return false;
    }
}
