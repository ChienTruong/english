package rio.it.App.Transform;

import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Entity.SubQuestionEntity;

/**
 * Created by chien on 15/04/2018.
 */
public interface SubQuestionTransform {

    SubQuestionEntity convertSubQuestionDtoToEntity(SubQuestionDto subQuestionDto);
}
