package rio.it.App.Transform;

import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.Model.PartQuestionModel;

public interface EntityTransformToModel {
    PartQuestionModel transformPartQuestionEntityToModel(PartQuestionEntity partQuestionEntity);
}
