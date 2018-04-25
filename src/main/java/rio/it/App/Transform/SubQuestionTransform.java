package rio.it.App.Transform;

import rio.it.App.Entity.SubQuestionEntity;
import rio.it.App.Model.SubQuestionModel;

public interface SubQuestionTransform {
    /**
     * convert to SubQuestion entity form SubQuestion Model
     * @author Son Nguyen
     * @param subQuestionModel
     * @return the subQuestion Entity
     */
    SubQuestionEntity convertSubQuestionModelToEntity(SubQuestionModel subQuestionModel);

    /**
     * convert to SubQuestion Model form subQuestion entity
     * @author Son Nguyen
     * @param subQuestionEntity
     * @return the subQuestion Model
     */
    SubQuestionModel convertSubQuestionEntityToModel(SubQuestionEntity subQuestionEntity);
}
