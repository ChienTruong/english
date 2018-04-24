package rio.it.App.Transform;

import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Entity.PartQuestionEntity;

public interface GenericTransform {
    PartQuestionEntity transformPartQuestionModelToEntity(PartQuestionModel partQuestionModel);
}
