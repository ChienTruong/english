package rio.it.App.Util.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

import java.util.List;

/**
 * Created by chien on 12/04/2018.
 */
public class VerifyQuestionPartSeven implements VerifyPartQuestion {
    private Logger logger = LoggerFactory.getLogger(VerifyQuestionPartSeven.class);
    @Override
    public boolean verify(PartQuestionDto partQuestionDto) {
        logger.info("Begin Verify Part Seven with condition: "+partQuestionDto);
        if (!partQuestionDto.getQuestionDtoList().isEmpty()){
            for (QuestionDto questionDto : partQuestionDto.getQuestionDtoList()){
                if (questionDto.getFileImageDtoList() == null){
                    System.out.println("Sai");
                    break;
                }

            }
            return true;
        }

        System.out.println("WWWW");
        return false;
    }
}
