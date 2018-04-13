package rio.it.App.Transform;

import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Entity.PartQuestionEntity;

import java.util.List;

/**
 * Created by chien on 10/04/2018.
 */
public interface Transform {
    List<PartQuestionEntity> transformListPartQuestion(List<PartQuestionDto> partQuestionDtoList);

    List<PartQuestionEntity> transformListQuestion(List<PartQuestionDto> partQuestionDtoList);
}
