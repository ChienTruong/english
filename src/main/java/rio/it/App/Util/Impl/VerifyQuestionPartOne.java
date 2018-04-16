package rio.it.App.Util.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Dto.FileImageDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Dto.SentenceDto;
import rio.it.App.Util.VerifyPartQuestion;


/**
 * Created by chien on 12/04/2018.
 */
public class VerifyQuestionPartOne implements VerifyPartQuestion {
    private Logger logger =  LoggerFactory.getLogger(VerifyQuestionPartOne.class);
    @Override
    public boolean verify(PartQuestionDto partQuestionDto) {
        if (partQuestionDto != null) {
            logger.info("Begin Check Part One" + partQuestionDto);
            if (!partQuestionDto.getQuestionDtoList().isEmpty()) {
                QuestionDto questionDto = partQuestionDto.getQuestionDtoList().get(0);
                FileImageDto fileImageDto = questionDto.getFileImageDtoList().get(0);
                SubQuestionDto subQuestionDto = questionDto.getSubQuestionDtoList().get(0);

                if (fileImageDto.getPathFileImage().getSize() > 0
                        && subQuestionDto.getSentenceDtoList().size() == 4
                        && subQuestionDto.getAnswer() != null){

                    for (SentenceDto sentenceDto : subQuestionDto.getSentenceDtoList()){
                        if (sentenceDto.getSentenceEn().isEmpty()
                                || sentenceDto.getCharacter() == null) {
                            return false;
                        }
                    }
                    return true;

                }
            }
        }
        return false;
    }
}
