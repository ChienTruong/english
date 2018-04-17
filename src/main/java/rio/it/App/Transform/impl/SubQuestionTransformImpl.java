package rio.it.App.Transform.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Entity.SubQuestionEntity;
import rio.it.App.Transform.SubQuestionTransform;

/**
 * Created by chien on 13/04/2018.
 */
@Service
public class SubQuestionTransformImpl implements SubQuestionTransform{
    private Logger logger = LoggerFactory.getLogger(SubQuestionTransformImpl.class);
    @Override
    public SubQuestionEntity convertSubQuestionDtoToEntity(SubQuestionDto subQuestionDto) {
        SubQuestionEntity subQuestionEntity = null;
        logger.info("Begin convertSubQuestionDtoToEntity with type Dto: "+subQuestionDto);
        if (subQuestionDto != null){
            subQuestionEntity = new SubQuestionEntity();
            subQuestionEntity.setSubQuestionId(subQuestionDto.getSubQuestionId());
            subQuestionEntity.setAnswer(subQuestionDto.getAnswer());
            subQuestionEntity.setSentenceAsk(subQuestionDto.getSentenceAsk());
            subQuestionEntity.setTranslateAsk(subQuestionDto.getTranslateAsk());
        }
        logger.info("End convertSubQuestionDtoToEntity with result: "+subQuestionEntity);
        return subQuestionEntity;
    }

    @Override
    public SubQuestionDto convertSubQuestionEntityToDto(SubQuestionEntity subQuestionEntity) {
        SubQuestionDto subQuestionDto = null;
        logger.info("Begin convertSubQuestionEntityToDto with type Entity: "+subQuestionEntity);
        if (subQuestionEntity != null){
            subQuestionDto = new SubQuestionDto();
            subQuestionDto.setSubQuestionId(subQuestionEntity.getSubQuestionId());
            subQuestionDto.setAnswer(subQuestionEntity.getAnswer());
            subQuestionDto.setSentenceAsk(subQuestionEntity.getSentenceAsk());
            subQuestionDto.setTranslateAsk(subQuestionEntity.getTranslateAsk());
        }
        logger.info("End convertSubQuestionEntityToDto with result: "+subQuestionDto);
        return subQuestionDto;
    }
}
