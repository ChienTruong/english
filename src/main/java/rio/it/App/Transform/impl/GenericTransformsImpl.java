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


//        }
//        partQuestionEntity.setQuestionEntityList(questionEntities);
//        logger.info("End transformPartQuestionModelToEntity with result :" + partQuestionEntity);


        PartQuestionEntity partQuestionEntity = this.partQuestionTransform.convertPartQuestionModelToEntity(partQuestionModel);
        partQuestionEntity.setQuestionEntityList(new ArrayList<>());
        // transform questionModelToEntity
        for (QuestionModel questionModel : partQuestionModel.getQuestionModelList()) {

            QuestionEntity questionEntity = this.questionTransform.convertQuestionModelToEntity(questionModel);
            questionEntity.setFileImageEntityList(new ArrayList<>());
            questionEntity.setParagraphEntityList(new ArrayList<>());
            questionEntity.setSubQuestionEntityList(new ArrayList<>());

            partQuestionEntity.getQuestionEntityList().add(questionEntity);
            questionEntity.setPartQuestionEntity(partQuestionEntity);

            if (questionModel.getFileImageModelList() != null && !questionModel.getFileImageModelList().isEmpty()) {
                //transform fileImageModelToEntity
                for (FileImageModel fileImageModel : questionModel.getFileImageModelList()) {
                    FileImageEntity fileImageEntity = fileImageTransform.convertFileImageModelToEntity(fileImageModel);
                    questionEntity.getFileImageEntityList().add(fileImageEntity);
                    fileImageEntity.setQuestionEntity(questionEntity);
                }
            }

            if (questionModel.getParagraphModelList() != null && !questionModel.getParagraphModelList().isEmpty()) {
                //transform paragrapModelToEntity
                for (ParagraphModel paragraphModel : questionModel.getParagraphModelList()) {
                    ParagraphEntity paragraphEntity = this.paragraphTransform.convertParagraphModelToEntity(paragraphModel);
                    questionEntity.getParagraphEntityList().add(paragraphEntity);
                    paragraphEntity.setQuestionEntity(questionEntity);
                }
            }
            if (questionModel.getSubQuestionModelList() != null && !questionModel.getSubQuestionModelList().isEmpty()) {
                //transform subQuestionModelToEntity
                for (SubQuestionModel subQuestionModel : questionModel.getSubQuestionModelList()) {
                    SubQuestionEntity subQuestionEntity = this.subQuestionTransform.convertSubQuestionModelToEntity(subQuestionModel);
                    subQuestionEntity.setSentenceEntityList(new ArrayList<>());
                    questionEntity.getSubQuestionEntityList().add(subQuestionEntity);
                    if (subQuestionModel.getSentenceAsk() != null && !subQuestionModel.getSentenceAsk().isEmpty()) {
                        //transform sentenceModelToEntity
                        for (SentenceModel sentenceModel : subQuestionModel.getSentenceModelList()) {
                            SentenceEntity sentenceEntity = this.sentenceTransform.convertSentenceModelToEntity(sentenceModel);
                            subQuestionEntity.getSentenceEntityList().add(sentenceEntity);
                            sentenceEntity.setSubQuestionEntity(subQuestionEntity);
                        }
                    }
                    subQuestionEntity.setQuestionEntity(questionEntity);
                }
            }
        }


        return partQuestionEntity;
    }
}
