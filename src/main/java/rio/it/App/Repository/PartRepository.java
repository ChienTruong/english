package rio.it.App.Repository;

import rio.it.App.Model.PartModel;
import rio.it.App.Model.PartQuestionModel;

import java.util.List;
import java.util.UUID;

/**
 * Created by chien on 23/04/2018.
 */
public interface PartRepository {

    PartModel findByName(String name);
    List<UUID> getListIdOfPartQuestionByNamePart(String namePart);
    List<PartQuestionModel> getAllPartQuestionModelThisAccount(String namePart,String email);

    List<PartQuestionModel> getAllParQuestionByNamePart(String namePart);
}
