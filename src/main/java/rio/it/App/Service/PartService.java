package rio.it.App.Service;

import rio.it.App.Model.PartModel;
import rio.it.App.Model.PartQuestionModel;

import java.util.List;

/**
 * Created by chien on 10/04/2018.
 */
public interface PartService {

    boolean checkExist(String namePart);

    PartModel findByName(String namePart);

    PartModel findById(Long idPartQuestion);

    List<Long> getAllIdOfListPartQuestion(String namePart);

    List<PartQuestionModel> getAllPartQuestionModelThisAccount(String namePart,String email);

}
