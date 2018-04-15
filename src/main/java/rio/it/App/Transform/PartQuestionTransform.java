package rio.it.App.Transform;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Entity.PartQuestionEntity;

/**
 * Created by chien on 10/04/2018.
 */
public interface PartQuestionTransform {

    /**
     * convert partQuestionDto to partQuestionEntity
     * @param partQuestionDto
     * @return partQuestionEntity
     * @author Quang Lai
     */
    PartQuestionEntity convertPartQuestionDtoToEntity(PartQuestionDto partQuestionDto);

    /**
     * convert partQuestionEntity to partQuestionDto
     * @param partQuestionEntity
     * @return partQuestionDto
     * @author Quang Lai
     */
    PartQuestionDto convertPartQuestionEntityToDto(PartQuestionEntity partQuestionEntity);

}
