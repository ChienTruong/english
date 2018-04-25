package rio.it.App.Transform;

import rio.it.App.Entity.SentenceEntity;
import rio.it.App.Model.SentenceModel;

public interface SentenceTransform {
    /**
     * convert to SentenceEntity form SentenceModel
     * @author Son Nguyen
     * @param sentenceModel
     * @return the sentence entity
     */
    SentenceEntity convertSentenceModelToEntity(SentenceModel sentenceModel);

    /**
     * convert to SentenceEntity form SentenceModel
     * @author Son Nguyen
     * @param sentenceEntity
     * @return the sentence model
     */
    SentenceModel convertSentenceEntityToModel(SentenceEntity sentenceEntity);
}
