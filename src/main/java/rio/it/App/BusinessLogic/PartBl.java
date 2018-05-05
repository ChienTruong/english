package rio.it.App.BusinessLogic;

import rio.it.App.Model.PartQuestionModel;

import java.util.List;

/**
 * Created by chien on 24/04/2018.
 */
public interface PartBl {

    PartQuestionModel getPartQuestionRandom(String namePart, String emailUser);
    List<PartQuestionModel> getAllPartQuestion(String namePart,String emailUser);
}
