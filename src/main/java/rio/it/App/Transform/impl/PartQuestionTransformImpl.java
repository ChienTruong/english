package rio.it.App.Transform.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.Transform.PartQuestionTransform;

/**
 * Created by ngocson on 12/04/2018.
 */
@Service
public class PartQuestionTransformImpl implements PartQuestionTransform {

    private Logger logger = LoggerFactory.getLogger(PartQuestionTransformImpl.class);

    @Override
    public PartQuestionEntity convertPartQuestionDtoToEntity(PartQuestionDto partQuestionDto) {
        PartQuestionEntity partQuestionEntity = null;
        logger.info("Begin convertPartQuestionDtoToEntity with Dto: " + partQuestionDto);
        if (partQuestionDto != null) {
            partQuestionEntity = new PartQuestionEntity();
            partQuestionEntity.setPathFileMp3(partQuestionDto.getNamePart());
        }
        return partQuestionEntity;
    }

    @Override
    public PartQuestionDto convertPartQuestionEntityToDto(PartQuestionEntity partQuestionEntity) {
        return null;
    }
}
