package rio.it.App.Transform;

import rio.it.App.Dto.QuestionDto;
import rio.it.App.Entity.QuestionEntity;

/**
 * Created by ngocson on 12/04/2018.
 */
public interface QuestionTransform {
    /**
     *
     * convert to question entity form questionDto
     * @author Son Nguyen
     * @param questionDto
     * @return the questionEntity
     */
    QuestionEntity convertQuestionDtoToEntity(QuestionDto questionDto);

    /**
     *
     * convert to question dto form questionEntity
     * @author Son Nguyen
     * @param questionEntity
     * @return the question dto
     */
    QuestionDto convertQuestionEntityToDto(QuestionEntity questionEntity);
}
