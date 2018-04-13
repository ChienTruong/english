package rio.it.App.Transform.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Entity.QuestionEntity;
import rio.it.App.Transform.QuestionTransform;

/**
 * Created by ngocson on 12/04/2018.
 */
@Service
public class QuestionTransformImpl implements QuestionTransform {
    private Logger logger = LoggerFactory.getLogger(QuestionTransformImpl.class);

    @Override
    public QuestionEntity convertQuestionDtoToEntity(QuestionDto questionDto) {
        QuestionEntity questionEntity = null;
        if (questionDto != null) {
        }
        return null;
    }
}
