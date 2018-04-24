package rio.it.App.Transform.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rio.it.App.Entity.SubQuestionEntity;
import rio.it.App.Model.SubQuestionModel;
import rio.it.App.Transform.SubQuestionTransform;

/**
 * Created by chien on 13/04/2018.
 */
@Service
public class SubQuestionTransformImpl implements SubQuestionTransform {

    private Logger logger = LoggerFactory.getLogger(SubQuestionTransformImpl.class);

    @Override
    public SubQuestionEntity convertSubQuestionModelToEntity(SubQuestionModel subQuestionModel) {
        SubQuestionEntity subQuestionEntity = null;
        logger.info("Begin convertSubQuestionModelToEntity with type Model: " + subQuestionModel);
        if (subQuestionModel != null) {
            subQuestionEntity = new SubQuestionEntity();
            subQuestionEntity.setSubQuestionId(subQuestionModel.getSubQuestionId());
            subQuestionEntity.setAnswer(subQuestionModel.getAnswer());
            subQuestionEntity.setSentenceAsk(subQuestionModel.getSentenceAsk());
            subQuestionEntity.setTranslateAsk(subQuestionModel.getTranslateAsk());
        }
        logger.info("End convertSubQuestionModelToEntity with result: " + subQuestionEntity);
        return subQuestionEntity;
    }

    @Override
    public SubQuestionModel convertSubQuestionEntityToModel(SubQuestionEntity subQuestionEntity) {
        SubQuestionModel subQuestionModel = null;
        logger.info("Begin convertSubQuestionEntityToModel with type Entity: " + subQuestionEntity);
        if (subQuestionEntity != null) {
            subQuestionModel = new SubQuestionModel();
            subQuestionModel.setSubQuestionId(subQuestionEntity.getSubQuestionId());
            subQuestionModel.setAnswer(subQuestionEntity.getAnswer());
            subQuestionModel.setSentenceAsk(subQuestionEntity.getSentenceAsk());
            subQuestionModel.setTranslateAsk(subQuestionEntity.getTranslateAsk());
        }
        logger.info("End convertSubQuestionEntityToModel with result: " + subQuestionModel);
        return subQuestionModel;
    }
}
