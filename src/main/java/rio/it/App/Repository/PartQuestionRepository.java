package rio.it.App.Repository;

import rio.it.App.Model.PartQuestionModel;

import java.util.UUID;

/**
 * Created by chien on 23/04/2018.
 */
public interface PartQuestionRepository {

    /**
     * save object part question model
     * @param partQuestionModel
     */
    void save(PartQuestionModel partQuestionModel);

    PartQuestionModel findById(Long idOfPartQuestion);

    void update(Long partQuestionId, PartQuestionModel partQuestionModel);

    PartQuestionModel findByUUID(UUID uuidPartQuestion);
}
