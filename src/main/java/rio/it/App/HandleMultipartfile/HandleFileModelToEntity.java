package rio.it.App.HandleMultipartfile;

import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.Model.PartQuestionModel;

/**
 * Created by ngocson on 23/04/2018.
 */
public interface HandleFileModelToEntity {
    /**
     * create folder Mp3 and Image
     *
     * if window then C:\\User
     *
     * if linux then /home/User
     * @param partQuestionEntity
     * @param partQuestionModel
     * @Author Son Nguyen
     */
    void HandleFileModelToEntity(PartQuestionEntity partQuestionEntity, PartQuestionModel partQuestionModel);
    void HandleFileEntityToModel(PartQuestionEntity partQuestionEntity, PartQuestionModel partQuestionModel);

}
