package rio.it.App.Transform;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Entity.PartQuestionEntity;

/**
 * Created by chien on 10/04/2018.
 */
public interface PartQuestionTransform {

    PartQuestionEntity convertPartQuestionDtoToEntity(PartQuestionDto partQuestionDto);

}
