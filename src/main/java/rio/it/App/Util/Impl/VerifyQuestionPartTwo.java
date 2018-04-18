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
public class VerifyQuestionPartTwo implements VerifyPartQuestion {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyQuestionPartTwo.class);

    @Override
    public boolean verify(PartQuestionDto partQuestionDto) {
        LOGGER.info("Do verify for partQuestionDto part two");
        if (verifyItIsPartTwo(partQuestionDto)) {
            return verifyItDoNotRedundant(partQuestionDto);
        }
        LOGGER.info("Error ! Verify for partQuestionDto part two");
        return false;
    }

    /**
     * @param partQuestionDto
     * @return
     */
    private boolean verifyItDoNotRedundant(PartQuestionDto partQuestionDto) {
        FunctionVerify functionVerify = new FunctionVerify();
        if (partQuestionDto != null) {
            if (functionVerify.verifyNamePart(partQuestionDto.getNamePart())) {
                if (!functionVerify.verifyFileNull(partQuestionDto.getPathFileMp3())) {
                    if (functionVerify.verifySuffixOfFile(partQuestionDto.getPathFileMp3(), "mp3")
                            && functionVerify.verifySizeOfFile(partQuestionDto.getPathFileMp3())) {
                        List<QuestionDto> questionDtoList = partQuestionDto.getQuestionDtoList();
                        if (functionVerify.verifyListNotNullAndNotEmpty(questionDtoList)
                                && questionDtoList.size() <= 30) {

                            for (QuestionDto questionDto : questionDtoList) {
                                if (!functionVerify.verifyListNotNullAndNotEmpty(questionDto.getParagraphDtoList())
                                        && !functionVerify.verifyListNotNullAndNotEmpty(questionDto.getFileImageDtoList())
                                        && functionVerify.verifyListNotNullAndNotEmpty(questionDto.getSubQuestionDtoList())) {
                                    List<SubQuestionDto> subQuestionDtoList = questionDto.getSubQuestionDtoList();
                                    if (functionVerify.verifyListNotNullAndNotEmpty(subQuestionDtoList)
                                            && subQuestionDtoList.size() <= 1) {

                                        for (SubQuestionDto subQuestionDto : subQuestionDtoList) {
                                            if (functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getAnswer().toString())) {
                                                if (functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getSentenceAsk())) {
                                                    List<SentenceDto> sentenceDtoList = subQuestionDto.getSentenceDtoList();
                                                    if (functionVerify.verifyListNotNullAndNotEmpty(sentenceDtoList)) {
                                                        for (SentenceDto sentenceDto : sentenceDtoList) {
                                                            if (!functionVerify.verifyStringNotNullAndNoEmpty(sentenceDto.getSentenceEn())) {
                                                                return false;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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

    /**
     * @param partQuestionDto
     * @return
     */
    private boolean verifyItIsPartTwo(PartQuestionDto partQuestionDto) {
        if (partQuestionDto.getPathFileMp3().getSize() != 0) {
            if (!partQuestionDto.getQuestionDtoList().isEmpty()) {
                for (QuestionDto questionDto : partQuestionDto.getQuestionDtoList()) {
                    if (questionDto.getSubQuestionDtoList().size() != 1) {
                        return false;
                    }
                    SubQuestionDto subQuestionDto = questionDto.getSubQuestionDtoList().get(0);
                    if (subQuestionDto.getSentenceAsk().isEmpty()
                            || subQuestionDto.getSentenceDtoList().size() != 3
                            || subQuestionDto.getSentenceDtoList().stream()
                            .anyMatch(sentenceDto -> sentenceDto.getSentenceEn().isEmpty())) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }


}
