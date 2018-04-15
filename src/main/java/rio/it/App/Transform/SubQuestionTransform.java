package rio.it.App.Transform;

import rio.it.App.Entity.SubQuestionEntity;
import rio.it.App.Dto.SubQuestionDto;

public interface SubQuestionTransform {
    /**
     * convert to SubQuestion entity form SubQuestion dto
     * @author Son Nguyen
     * @param subQuestionDto
     * @return the subQuestion Entity
     */
    SubQuestionEntity convertSubQuestionDtoToEntity(SubQuestionDto subQuestionDto);

    /**
     * convert to SubQuestion dto form subQuestion entity
     * @author Son Nguyen
     * @param subQuestionEntity
     * @return the subQuestion dto
     */
    SubQuestionDto convertSubQuestionEntityToDto(SubQuestionEntity subQuestionEntity);
}
