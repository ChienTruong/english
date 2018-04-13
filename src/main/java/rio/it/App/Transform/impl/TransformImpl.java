package rio.it.App.Transform.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.Entity.QuestionEntity;
import rio.it.App.Transform.PartQuestionTransform;
import rio.it.App.Transform.QuestionTransform;
import rio.it.App.Transform.Transform;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chien on 13/04/2018.
 */
@Component
public class TransformImpl implements Transform {

    @Autowired
    PartQuestionTransform partQuestionTransform;
    @Autowired
    QuestionTransform questionTransform;

    @Override
    public List<PartQuestionEntity> transformListPartQuestion(List<PartQuestionDto> partQuestionDtoList) {
        return this.trans(partQuestionDtoList);
    }

    @Override
    public List<PartQuestionEntity> transformListQuestion(List<PartQuestionDto> partQuestionDtoList) {
        List<PartQuestionEntity> partQuestionEntityList = new ArrayList<>();
        for (PartQuestionDto partQuestionDto : partQuestionDtoList) {
        }
        return null;
    }

    private List<PartQuestionEntity> trans(List<PartQuestionDto> partQuestionDtoList) {
        List<PartQuestionEntity> partQuestionEntityList = new ArrayList<>(0);
        for (PartQuestionDto partQuestionDto : partQuestionDtoList) {
            partQuestionEntityList.add(this.partQuestionTransform.convertPartQuestionDtoToEntity(partQuestionDto));
        }
        return partQuestionEntityList;
    }
}
