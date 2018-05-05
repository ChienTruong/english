package rio.it.App.Transform;

import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Entity.PartQuestionEntity;

public interface ModelTransformEntity {
    PartQuestionEntity transformPartQuestionModelToEntity(PartQuestionModel partQuestionModel);
}
