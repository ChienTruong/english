package rio.it.App.Util.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

/**
 * Created by chien on 12/04/2018.
 */
public class VerifyQuestionPartTwo implements VerifyPartQuestion {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyQuestionPartTwo.class);

    @Override
    public boolean verify(PartQuestionDto partQuestionDto) {
        LOGGER.info("Do verify for partQuestionDto part two");
        if (verifyItIsPartTwo(partQuestionDto)) {
            return verifyItIsRedundant(partQuestionDto);
        }
        LOGGER.info("Error ! Verify for partQuestionDto part two");
        return false;
    }

    private boolean verifyItIsRedundant(PartQuestionDto partQuestionDto) {
        return false;
    }

    private boolean verifyItIsPartTwo(PartQuestionDto partQuestionDto) {
        if (partQuestionDto.getPathFileMp3().getSize() != 0) {
            if (!partQuestionDto.getQuestionDtoList().isEmpty()) {
                for (QuestionDto questionDto : partQuestionDto.getQuestionDtoList()) {
                    if (questionDto.getSubQuestionDtoList().size() != 1) {
                        break;
                    }
                    SubQuestionDto subQuestionDto = questionDto.getSubQuestionDtoList().get(0);
                    if (subQuestionDto.getSentenceAsk().isEmpty()
                            || subQuestionDto.getSentenceDtoList().size() == 3
                            || subQuestionDto.getSentenceDtoList().stream()
                            .anyMatch(sentenceDto -> sentenceDto.getSentenceEn().isEmpty())) {
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
