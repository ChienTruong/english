package rio.it.App.Transform;

import rio.it.App.Entity.SubQuestionEntity;
import rio.it.App.Dto.SubQuestionDto;

public interface SubQuestionTransform {
    SubQuestionEntity convertSubQuestionDtoToEntity(SubQuestionDto subQuestionDto);
    SubQuestionDto convertSubQuestionEntityToDto(SubQuestionEntity subQuestionEntity);
}
