package rio.it.App.Transform;

import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Entity.PartQuestionEntity;

/**
 * Created by chien on 10/04/2018.
 */
public interface Transform {
    PartQuestionEntity doTransformForPartQuestion(PartQuestionDto partQuestionDto);
}
