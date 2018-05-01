package rio.it.App.Transform.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rio.it.App.Entity.*;
import rio.it.App.Model.*;
import rio.it.App.Transform.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chien on 13/04/2018.
 */
@Service
public class GenericTransformsImpl implements GenericTransform {

    private PartQuestionTransform partQuestionTransform;
    private QuestionTransform questionTransform;
    private SubQuestionTransform subQuestionTransform;
    private ParagraphTransform paragraphTransform;
    private SentenceTransform sentenceTransform;
    private FileImageTransform fileImageTransform;

    private Logger logger = LoggerFactory.getLogger(GenericTransformsImpl.class);

    @Autowired
    public GenericTransformsImpl(PartQuestionTransform partQuestionTransform, QuestionTransform questionTransform, SubQuestionTransform subQuestionTransform, ParagraphTransform paragraphTransform, SentenceTransform sentenceTransform, FileImageTransform fileImageTransform) {
        this.partQuestionTransform = partQuestionTransform;
        this.questionTransform = questionTransform;
        this.subQuestionTransform = subQuestionTransform;
        this.paragraphTransform = paragraphTransform;
        this.sentenceTransform = sentenceTransform;
        this.fileImageTransform = fileImageTransform;
    }

    public PartQuestionEntity transformPartQuestionModelToEntity(PartQuestionModel partQuestionModel) {
//        logger.info("Begin transformPartQuestionModelToEntity with condition :" + partQuestionModel);
        PartQuestionEntity partQuestionEntity = this.partQuestionTransform.convertPartQuestionModelToEntity(partQuestionModel);
        partQuestionEntity.setQuestionEntityList(new ArrayList<>());
        // transform questionModelToEntity
        List<QuestionEntity> questionEntities  = new ArrayList<>();
        for (QuestionModel questionModel : partQuestionModel.getQuestionModelList()) {

            QuestionEntity questionEntity = this.questionTransform.convertQuestionModelToEntity(questionModel);

            questionEntity.setSubQuestionEntityList(new ArrayList<>());
            questionEntity.setFileImageEntityList(new ArrayList<>());

            questionEntity.setPartQuestionEntity(partQuestionEntity);

            for (FileImageModel fileImageModel : questionModel.getFileImageModelList()){

                FileImageEntity fileImageEntity = fileImageTransform.convertFileImageModelToEntity(fileImageModel);
                fileImageEntity.setQuestionEntity(questionEntity);

                questionEntity.getFileImageEntityList().add(fileImageEntity);
            }

            for (SubQuestionModel subQuestionModel : questionModel.getSubQuestionModelList()){

                SubQuestionEntity subQuestionEntity = subQuestionTransform.convertSubQuestionModelToEntity(subQuestionModel);

                subQuestionEntity.setQuestionEntity(questionEntity);

                questionEntity.getSubQuestionEntityList().add(subQuestionEntity);

            }


            partQuestionEntity.getQuestionEntityList().add(questionEntity);
//            if (questionModel.getFileImageModelList()!= null && !questionModel.getFileImageModelList().isEmpty()) {
//                //transform fileImageModelToEntity
//                for (FileImageModel fileImageModel : questionModel.getFileImageModelList()) {
//
//                    FileImageEntity fileImageEntity = fileImageTransform.convertFileImageModelToEntity(fileImageModel);
//
//
////                    fileImageEntities.add(fileImageEntity);
//                    questionEntity.getFileImageEntityList().add(fileImageEntity);
//                    fileImageEntity.setQuestionEntity(questionEntity);
//
//                }
////                    questionEntity.setFileImageEntityList(fileImageEntities);
//
//            }


        }
//        partQuestionEntity.setQuestionEntityList(questionEntities);
//        logger.info("End transformPartQuestionModelToEntity with result :" + partQuestionEntity);
        return partQuestionEntity;
    }
}
