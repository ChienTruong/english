package rio.it.App.Transform.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.Transform.PartQuestionTransform;

/**
 * Created by ngocson on 12/04/2018.
 */
@Service
public class PartQuestionTransformImpl implements PartQuestionTransform {

    private Logger logger = LoggerFactory.getLogger(PartQuestionTransformImpl.class);

    @Override
    public PartQuestionEntity convertPartQuestionModelToEntity(PartQuestionModel partQuestionModel) {
        PartQuestionEntity partQuestionEntity = null;
        logger.info("Begin convertPartQuestionModelToEntity with Model: " + partQuestionModel);
        if (partQuestionModel != null) {
            partQuestionEntity = new PartQuestionEntity();
        }
        logger.info("End convertPartQuestionModelToEntity with result: " + partQuestionEntity);
        return partQuestionEntity;
    }

    @Override
    public PartQuestionModel convertPartQuestionEntityToModel(PartQuestionEntity partQuestionEntity) {

        PartQuestionModel partQuestionModel = null;
        logger.info("Begin convertPartQuestionModelTo Model with Entity: "+partQuestionEntity);
        if (partQuestionEntity != null){
            partQuestionModel = new PartQuestionModel();
        }
        logger.info("End convertPartQuestionModelTo Model with result: "+partQuestionModel);
        return partQuestionModel;
    }
}
