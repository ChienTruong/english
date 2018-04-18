package rio.it.App.Transform.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Entity.QuestionEntity;
import rio.it.App.Transform.QuestionTransform;

/**
 * Created by ngocson on 12/04/2018.
 */
@Service
public class QuestionTransformImpl implements QuestionTransform {

    private Logger logger = LoggerFactory.getLogger(QuestionTransformImpl.class);

    @Override
    public QuestionEntity convertQuestionDtoToEntity(QuestionDto questionDto) {
        QuestionEntity questionEntity = null;
        logger.info("Begin convertQuestionDtoToEntity with type Dto: "+questionDto);
        if (questionDto != null) {
            questionEntity = new QuestionEntity();
            questionEntity.setQuestionEntityId(questionDto.getQuestionEntityId());
            questionEntity.setTimeEnd(questionDto.getTimeEnd());
            questionEntity.setTimeStart(questionDto.getTimeStart());
        }
        logger.info("End convertQuestionDtoToEntity result: "+questionEntity);
        return questionEntity;
    }

    @Override
    public QuestionDto convertQuestionEntityToDto(QuestionEntity questionEntity) {
        QuestionDto questionDto = null;
        logger.info("Begin convertQuestionEntityToDto with type Entity: "+questionEntity);
        if (questionEntity != null){
            questionDto = new QuestionDto();
            questionDto.setQuestionEntityId(questionEntity.getQuestionEntityId());
            questionDto.setTimeEnd(questionEntity.getTimeEnd());
            questionDto.setTimeStart(questionEntity.getTimeStart());
        }
        logger.info("End convertQuestionEntityToDto with result: "+questionDto);
        return questionDto;
    }
}
