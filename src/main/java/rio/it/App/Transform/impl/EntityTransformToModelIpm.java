package rio.it.App.Transform.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.Entity.QuestionEntity;
import rio.it.App.Entity.SubQuestionEntity;
import rio.it.App.Model.*;
import rio.it.App.Transform.*;

import java.util.ArrayList;
@Service
public class EntityTransformToModelIpm implements EntityTransformToModel{


    private PartQuestionTransform partQuestionTransform;
    private QuestionTransform questionTransform;
    private ParagraphTransform paragraphTransform;
    private SubQuestionTransform subQuestionTransform;
    private SentenceTransform sentenceTransform;

    @Autowired
    public EntityTransformToModelIpm(PartQuestionTransform partQuestionTransform, QuestionTransform questionTransform, ParagraphTransform paragraphTransform, SubQuestionTransform subQuestionTransform, SentenceTransform sentenceTransform) {
        this.partQuestionTransform = partQuestionTransform;
        this.questionTransform = questionTransform;
        this.paragraphTransform = paragraphTransform;
        this.subQuestionTransform = subQuestionTransform;
        this.sentenceTransform = sentenceTransform;
    }

    @Override
    public PartQuestionModel transformPartQuestionEntityToModel(PartQuestionEntity partQuestionEntity) {

        PartQuestionModel  partQuestionModel = partQuestionTransform.convertPartQuestionEntityToModel(partQuestionEntity);
        partQuestionModel.setQuestionModelList(new ArrayList<>());
        partQuestionEntity.getQuestionEntityList().forEach(questionEntity -> {

            QuestionModel questionModel = questionTransform.convertQuestionEntityToModel(questionEntity);
            convertParagraph(questionModel,questionEntity);
            convertSupQuestion(questionModel,questionEntity);
            partQuestionModel.getQuestionModelList().add(questionModel);

        });

        return null;
    }
    public void convertParagraph(QuestionModel questionModell, QuestionEntity questionEntity){

        questionModell.setParagraphModelList(new ArrayList<>());
        if (questionEntity.getParagraphEntityList() != null && questionEntity.getParagraphEntityList().isEmpty())

            questionEntity.getParagraphEntityList().forEach(paragraphEntity -> {
                ParagraphModel paragraphModel  = paragraphTransform.convertParagraphEntityToModel(paragraphEntity);
                questionModell.getParagraphModelList().add(paragraphModel);
            });
    }
    public void convertSupQuestion(QuestionModel questionModell, QuestionEntity questionEntity){

        questionModell.setSubQuestionModelList(new ArrayList<>());
        if (questionEntity.getSubQuestionEntityList() != null && questionEntity.getSubQuestionEntityList().isEmpty()){

            questionEntity.getSubQuestionEntityList().forEach(subQuestionEntity -> {

                SubQuestionModel subQuestionModel = subQuestionTransform.convertSubQuestionEntityToModel(subQuestionEntity);
                questionModell.getSubQuestionModelList().add(subQuestionModel);
                convertSentence(subQuestionModel,subQuestionEntity);
                questionModell.getSubQuestionModelList().add(subQuestionModel);

            });

        }
    }
    public void convertSentence(SubQuestionModel subQuestionModel, SubQuestionEntity subQuestionEntity){
          subQuestionModel.setSentenceModelList(new ArrayList<>());
          if(subQuestionEntity.getSentenceEntityList() != null && subQuestionEntity.getSentenceEntityList().isEmpty()){

             subQuestionEntity.getSentenceEntityList().forEach(sentenceEntity -> {
                 SentenceModel sentenceModel = sentenceTransform.convertSentenceEntityToModel(sentenceEntity);
                 subQuestionModel.getSentenceModelList().add(sentenceModel);
             });

          }
    }


}
