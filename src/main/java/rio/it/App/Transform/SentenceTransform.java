package rio.it.App.Transform;

import rio.it.App.Dto.SentenceDto;
import rio.it.App.Entity.SentenceEntity;

/**
 * Created by chien on 15/04/2018.
 */
public interface SentenceTransform {

    SentenceEntity convertSentenceDtoToEntity(SentenceDto sentenceDto);
}
