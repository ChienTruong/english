package rio.it.App.Transform.impl;

import rio.it.App.Dto.*;
import rio.it.App.Entity.*;
import rio.it.App.Transform.PartQuestionTransform;
import rio.it.App.Transform.QuestionTransform;

/**
 * Created by chien on 13/04/2018.
 */
public class Tet {
    private PartQuestionTransform partQuestionTransform = new PartQuestionTransformImpl();
    private QuestionTransform questionTransform = new QuestionTransformImpl();
    private SubQuestionTransformImpl subQuestionTransform = new SubQuestionTransformImpl();
    private ParagraphTransformImpl paragraphTransform = new ParagraphTransformImpl();
    private SentenceTransformImpl sentenceTransform = new SentenceTransformImpl();

    public static void main(String[] args) {
        Tet e = new Tet();
        PartQuestionDto partQuestionDto = new PartQuestionDto();
        PartQuestionEntity partQuestionEntity = e.partQuestionTransform.convertPartQuestionDtoToEntity(partQuestionDto);
        for (QuestionDto questionDto : partQuestionDto.getQuestionDtoList()) {
            QuestionEntity questionEntity = e.questionTransform.convertQuestionDtoToEntity(questionDto);
            partQuestionEntity.getQuestionEntityList().add(questionEntity);
            for (ParagraphDto paragraphDto : questionDto.getParagraphDtoList()) {
                ParagraphEntity paragraphEntity = e.paragraphTransform.trans(paragraphDto);
                questionEntity.getParagraphEntityList().add(paragraphEntity);
            }
            for (SubQuestionDto subQuestionDto : questionDto.getSubQuestionDtoList()) {
                SubQuestionEntity subQuestionEntity = e.subQuestionTransform.trans(subQuestionDto);
                questionEntity.getSubQuestionEntityList().add(subQuestionEntity);
                for (SentenceDto sentenceDto : subQuestionDto.getSentenceDtoList()) {
                    SentenceEntity sentenceEntity = e.sentenceTransform.trans(sentenceDto);
                    subQuestionEntity.getSentenceEntityList().add(sentenceEntity);
                }
            }
        }
        // repository.save partQuestionEntity
    }
}
