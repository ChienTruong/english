package rio.it.App.Transform.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rio.it.App.Model.QuestionModel;
import rio.it.App.Entity.QuestionEntity;
import rio.it.App.Transform.QuestionTransform;

import java.util.UUID;

/**
 * Created by ngocson on 12/04/2018.
 */
@Service
public class QuestionTransformImpl implements QuestionTransform {

    private Logger logger = LoggerFactory.getLogger(QuestionTransformImpl.class);

    @Override
    public QuestionEntity convertQuestionModelToEntity(QuestionModel questionModel) {
        QuestionEntity questionEntity = null;
        logger.info("Begin convertQuestionModelToEntity with type Model: "+ questionModel);
        if (questionModel != null) {
            questionEntity = new QuestionEntity();
            questionEntity.setTimeEnd(questionModel.getTimeEnd());
            questionEntity.setTimeStart(questionModel.getTimeStart());
        }
        logger.info("End convertQuestionModelToEntity result: "+questionEntity);
        return questionEntity;
    }

    @Override
    public QuestionModel convertQuestionEntityToModel(QuestionEntity questionEntity) {
        QuestionModel questionModel = null;
        logger.info("Begin convertQuestionEntityToModel with type Entity: "+questionEntity);
        if (questionEntity != null){
            questionModel = new QuestionModel();
            questionModel.setId(questionEntity.getUuid());
            questionModel.setTimeEnd(questionEntity.getTimeEnd());
            questionModel.setTimeStart(questionEntity.getTimeStart());
        }
        logger.info("End convertQuestionEntityToModel with result: "+questionModel);
        return questionModel;
    }
}
