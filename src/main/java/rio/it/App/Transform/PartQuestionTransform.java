package rio.it.App.Transform;

import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Entity.PartQuestionEntity;

/**
 * Created by chien on 10/04/2018.
 */
public interface PartQuestionTransform {

    /**
     * convert partQuestionModel to partQuestionEntity
     * @param partQuestionModel
     * @return partQuestionEntity
     * @author Quang Lai
     */
    PartQuestionEntity convertPartQuestionModelToEntity(PartQuestionModel partQuestionModel);

    /**
     * convert partQuestionEntity to partQuestionModel
     * @param partQuestionEntity
     * @return partQuestionModel
     * @author Quang Lai
     */
    PartQuestionModel convertPartQuestionEntityToModel(PartQuestionEntity partQuestionEntity);

}
