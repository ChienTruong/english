package rio.it.App.Transform;

import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Entity.PartQuestionEntity;

public interface GenericTransform {
    public PartQuestionEntity transformPartQuestionDtoToEntity(PartQuestionDto partQuestionDto);
}
