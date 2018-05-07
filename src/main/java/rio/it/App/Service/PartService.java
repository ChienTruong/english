package rio.it.App.Service;

import rio.it.App.Model.PartModel;
import rio.it.App.Model.PartQuestionModel;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by chien on 10/04/2018.
 */
public interface PartService {

    boolean checkExist(String namePart);

    PartModel findByName(String namePart);

    PartModel findById(Long idPartQuestion);

    List<UUID> getAllIdOfListPartQuestion(String namePart);

    List<PartQuestionModel> getAllPartQuestionModelThisAccount(String namePart,String email);

    Map<UUID,PartQuestionModel> getAllPartQuestionByNamePart(String namePart);
}
