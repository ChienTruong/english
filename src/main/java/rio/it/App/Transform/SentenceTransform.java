package rio.it.App.Transform;

import rio.it.App.Entity.SentenceEntity;
import rio.it.App.Dto.SentenceDto;

public interface SentenceTransform {
    /**
     * convert to SentenceEntity form SentenceDto
     * @author Son Nguyen
     * @param sentenceDto
     * @return the sentence entity
     */
    SentenceEntity convertSentenceDtoToEntity(SentenceDto sentenceDto);

    /**
     * convert to SentenceEntity form SentenceDto
     * @author Son Nguyen
     * @param sentenceEntity
     * @return the sentence dto
     */
    SentenceDto  convertSentenceEntityToDto(SentenceEntity sentenceEntity);
}
