package rio.it.App.Transform.impl;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rio.it.App.Dto.ParagraphDto;
import rio.it.App.Entity.ParagraphEntity;
import rio.it.App.Transform.ParagraphTransform;
import org.slf4j.Logger;

/**
 * Created by chien on 13/04/2018.
 */
@Service
public class ParagraphTransformImpl implements ParagraphTransform{
    private Logger logger = LoggerFactory.getLogger(ParagraphTransformImpl.class);

    @Override
    public ParagraphEntity convertParagraphDtoToEntity(ParagraphDto paragraphDto) {

        ParagraphEntity paragraphEntity  = null;
        logger.info("Begin convertParagraphDtoToEntity with Dto:"+paragraphDto);
        if (paragraphDto != null){
            paragraphEntity = new ParagraphEntity();
            paragraphEntity.setParagraph(paragraphDto.getParagraph());
        }
        logger.info("End convertParagraphDtoToEntity with result:"+paragraphEntity);
        return paragraphEntity;
    }

    @Override
    public ParagraphDto convertParagraphEntityToDto(ParagraphEntity paragraphEntity) {
        ParagraphDto paragraphDto = null;
        logger.info("Begin convertParagraphEntityToDto with Entity:"+paragraphEntity);
        if(paragraphEntity != null){
            paragraphEntity.setParagraph(paragraphDto.getParagraph());
        }
        logger.info("End convertParagraphEntityToDto with result:"+paragraphDto);
        return paragraphDto;
    }
}
