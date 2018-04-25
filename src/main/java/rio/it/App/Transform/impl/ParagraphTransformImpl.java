package rio.it.App.Transform.impl;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rio.it.App.Model.ParagraphModel;
import rio.it.App.Entity.ParagraphEntity;
import rio.it.App.Transform.ParagraphTransform;
import org.slf4j.Logger;

/**
 * Created by chien on 13/04/2018.
 */
@Service
public class ParagraphTransformImpl implements ParagraphTransform {

    private Logger logger = LoggerFactory.getLogger(ParagraphTransformImpl.class);

    @Override
    public ParagraphEntity convertParagraphModelToEntity(ParagraphModel paragraphModel) {
        ParagraphEntity paragraphEntity  = null;
        logger.info("Begin convertParagraphModelToEntity with Model:"+ paragraphModel);
        if (paragraphModel != null){
            paragraphEntity = new ParagraphEntity();
            paragraphEntity.setParagraph(paragraphModel.getParagraph());
        }
        logger.info("End convertParagraphModelToEntity with result:"+paragraphEntity);
        return paragraphEntity;
    }

    @Override
    public ParagraphModel convertParagraphEntityToModel(ParagraphEntity paragraphEntity) {
        ParagraphModel paragraphModel = null;
        logger.info("Begin convertParagraphEntityToModel with Entity:"+paragraphEntity);
        if(paragraphEntity != null){
            paragraphEntity.setParagraph(paragraphModel.getParagraph());
        }
        logger.info("End convertParagraphEntityToModel with result:"+paragraphModel);
        return paragraphModel;
    }
}
