package rio.it.App.Transform.impl;

import org.springframework.stereotype.Component;
import rio.it.App.Entity.PartEntity;
import rio.it.App.Model.PartModel;
import rio.it.App.Transform.PartTransform;

/**
 * Created by chien on 23/04/2018.
 */
@Component
public class PartTransformImpl implements PartTransform {

    @Override
    public PartModel convertPartEntityToModel(PartEntity partEntity) {
        PartModel partModel = null;
        if (partEntity != null){
            partModel = new PartModel();
            partModel.setPartId(partEntity.getPartId());
            partModel.setPartName(partEntity.getPartName());
        }
        return partModel;
    }
}
