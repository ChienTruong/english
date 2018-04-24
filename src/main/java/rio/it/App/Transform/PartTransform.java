package rio.it.App.Transform;

import rio.it.App.Entity.PartEntity;
import rio.it.App.Model.PartModel;

/**
 * Created by chien on 23/04/2018.
 */
public interface PartTransform {
    PartModel convertPartEntityToModel(PartEntity partEntity);
}
