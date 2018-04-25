package rio.it.App.HandleMultipartfile;

import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Entity.PartQuestionEntity;

/**
 * Created by ngocson on 23/04/2018.
 */
public interface HandleFile {
    void dosomething(PartQuestionEntity partQuestionEntity, PartQuestionDto partQuestionDto);
}
