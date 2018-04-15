package rio.it.App.Transform;

import rio.it.App.Entity.SentenceEntity;
import rio.it.App.Dto.SentenceDto;

public interface SentenceTransform {
    SentenceEntity convertSentenceDtoToEntity(SentenceDto sentenceDto);
    SentenceDto  convertSentenceEntityToDto(SentenceEntity sentenceEntity);
}
