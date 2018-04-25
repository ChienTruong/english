package rio.it.App.Transform.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rio.it.App.Model.SentenceModel;
import rio.it.App.Entity.SentenceEntity;
import rio.it.App.Transform.SentenceTransform;

/**
 * Created by chien on 13/04/2018.
 */
@Service
public class SentenceTransformImpl implements SentenceTransform {
    private Logger logger = LoggerFactory.getLogger(SentenceTransformImpl.class);

    @Override
    public SentenceEntity convertSentenceModelToEntity(SentenceModel sentenceModel) {
        SentenceEntity sentenceEntity = null;
        logger.info("Begin convertSentenceModelToEntity with type Model: "+ sentenceModel);
        if (sentenceModel != null){
            sentenceEntity = new SentenceEntity();
            sentenceEntity.setSentenceId(sentenceModel.getSentenceId());
            sentenceEntity.setCharacter(sentenceModel.getCharacter());
            sentenceEntity.setSentenceEn(sentenceModel.getSentenceEn());
            sentenceEntity.setSentenceVn(sentenceModel.getSentenceVn());
        }
        logger.info("End convertSentenceModelToEntity with result: "+sentenceEntity);
        return sentenceEntity;
    }

    @Override
    public SentenceModel convertSentenceEntityToModel(SentenceEntity sentenceEntity) {
        SentenceModel sentenceModel = null;
        logger.info("Begin convertSentenceEntityToModel with type Entity: "+sentenceEntity);
        if (sentenceEntity != null){
            sentenceModel = new SentenceModel();
            sentenceModel.setSentenceId(sentenceEntity.getSentenceId());
            sentenceModel.setCharacter(sentenceEntity.getCharacter());
            sentenceModel.setSentenceEn(sentenceEntity.getSentenceEn());
            sentenceModel.setSentenceVn(sentenceEntity.getSentenceVn());
        }
        logger.info("End convertSentenceEntityToModel with result: "+sentenceModel);
        return sentenceModel;
    }
}
