package rio.it.App.Transform.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rio.it.App.Dto.SentenceDto;
import rio.it.App.Entity.SentenceEntity;
import rio.it.App.Transform.SentenceTransform;

/**
 * Created by chien on 13/04/2018.
 */
@Service
public class SentenceTransformImpl implements SentenceTransform {
    private Logger logger = LoggerFactory.getLogger(SentenceTransformImpl.class);

    @Override
    public SentenceEntity convertSentenceDtoToEntity(SentenceDto sentenceDto) {
        SentenceEntity sentenceEntity = null;
        logger.info("Begin convertSentenceDtoToEntity with type dto: "+sentenceDto);
        if (sentenceDto != null){
            sentenceEntity = new SentenceEntity();
            sentenceEntity.setSentenceId(sentenceDto.getSentenceId());
            sentenceEntity.setCharacter(sentenceDto.getCharacter());
            sentenceEntity.setSentenceEn(sentenceDto.getSentenceEn());
            sentenceEntity.setSentenceVn(sentenceDto.getSentenceVn());
        }
        logger.info("End convertSentenceDtoToEntity with result: "+sentenceEntity);
        return sentenceEntity;
    }

    @Override
    public SentenceDto convertSentenceEntityToDto(SentenceEntity sentenceEntity) {
        SentenceDto sentenceDto = null;
        logger.info("Begin convertSentenceEntityToDto with type Entity: "+sentenceEntity);
        if (sentenceEntity != null){
            sentenceDto = new SentenceDto();
            sentenceDto.setSentenceId(sentenceEntity.getSentenceId());
            sentenceDto.setCharacter(sentenceEntity.getCharacter());
            sentenceDto.setSentenceEn(sentenceEntity.getSentenceEn());
            sentenceDto.setSentenceVn(sentenceEntity.getSentenceVn());
        }
        logger.info("End convertSentenceEntityToDto with result: "+sentenceDto);
        return sentenceDto;
    }
}
