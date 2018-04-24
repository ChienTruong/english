package rio.it.App.Transform;

import rio.it.App.Model.QuestionModel;
import rio.it.App.Entity.QuestionEntity;

/**
 * Created by ngocson on 12/04/2018.
 */
public interface QuestionTransform {
    /**
     *
     * convert to question entity form questionModel
     * @author Son Nguyen
     * @param questionModel
     * @return the questionEntity
     */
    QuestionEntity convertQuestionModelToEntity(QuestionModel questionModel);

    /**
     *
     * convert to question model form questionEntity
     * @author Son Nguyen
     * @param questionEntity
     * @return the question model
     */
    QuestionModel convertQuestionEntityToModel(QuestionEntity questionEntity);
}
