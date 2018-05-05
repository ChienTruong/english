package rio.it.App.Transform.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import rio.it.App.Entity.PartEntity;
import rio.it.App.Model.PartModel;
import rio.it.App.Transform.PartTransform;

/**
 * Created by chien on 23/04/2018.
 */
@Component
public class PartTransformImpl implements PartTransform {

    private Logger logger = LoggerFactory.getLogger(PartTransformImpl.class);
    @Override
    public PartModel convertPartEntityToModel(PartEntity partEntity) {
        PartModel partModel = null;
        logger.info("Begin convertPartEntityToModel with type Entity: "+partEntity);
        if (partEntity != null){
            partModel = new PartModel();
            partModel.setId(partEntity.getUuid());
            partModel.setPartName(partEntity.getPartName());
        }
        logger.info("End convertPartEntityToModel with result: "+partModel);
        return partModel;
    }
}
