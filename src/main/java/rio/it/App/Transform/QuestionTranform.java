package rio.it.App.Transform;

import rio.it.App.Dto.QuestionDto;
import rio.it.App.Entity.QuestionEntity;

/**
 * Created by ngocson on 12/04/2018.
 */
public interface QuestionTranform {
    QuestionEntity convertQuestionDtoToEntity(QuestionDto questionDto);
}
