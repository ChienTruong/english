package rio.it.App.Service;

import rio.it.App.Model.PartQuestionModel;

import java.util.UUID;

/**
 * Created by chien on 10/04/2018.
 */
public interface PartQuestionService {

    void save(PartQuestionModel partQuestionModel);

    PartQuestionModel getByUUID(UUID uuidPartQuestion);

    boolean checkExist(Long partQuestionId);

    void update(Long partQuestionId, PartQuestionModel partQuestionModel);
}
