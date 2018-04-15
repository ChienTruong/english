package rio.it.App.Transform.impl;

import org.springframework.stereotype.Service;
import rio.it.App.Dto.SentenceDto;
import rio.it.App.Entity.SentenceEntity;
import rio.it.App.Transform.SentenceTransform;

/**
 * Created by chien on 13/04/2018.
 */
@Service
public class SentenceTransformImpl implements SentenceTransform {

    @Override
    public SentenceEntity convertSentenceDtoToEntity(SentenceDto sentenceDto) {
        return null;
    }
}
