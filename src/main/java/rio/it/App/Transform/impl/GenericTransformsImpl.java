package rio.it.App.Transform.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rio.it.App.Dto.*;
import rio.it.App.Entity.*;
import rio.it.App.Transform.*;

import java.util.ArrayList;

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
    private   Logger logger = LoggerFactory.getLogger(GenericTransformsImpl.class);

    @Autowired
    public GenericTransformsImpl(PartQuestionTransform partQuestionTransform, QuestionTransform questionTransform, SubQuestionTransform subQuestionTransform, ParagraphTransform paragraphTransform, SentenceTransform sentenceTransform, FileImageTransform fileImageTransform) {
        this.partQuestionTransform = partQuestionTransform;
        this.questionTransform = questionTransform;
        this.subQuestionTransform = subQuestionTransform;
        this.paragraphTransform = paragraphTransform;
        this.sentenceTransform = sentenceTransform;
        this.fileImageTransform = fileImageTransform;
    }

    public PartQuestionEntity transformPartQuestionDtoToEntity(PartQuestionDto partQuestionDto) {


        logger.info("Begin transformPartQuestionDtoToEntity with condition :"+partQuestionDto);
        PartQuestionEntity partQuestionEntity = this.partQuestionTransform.convertPartQuestionDtoToEntity(partQuestionDto);
        partQuestionEntity.setQuestionEntityList(new ArrayList<>());
         // transform questionDtoToEntity
        for (QuestionDto questionDto : partQuestionDto.getQuestionDtoList()) {

            QuestionEntity questionEntity = this.questionTransform.convertQuestionDtoToEntity(questionDto);
            questionEntity.setFileImageEntityList(new ArrayList<>());
            questionEntity.setParagraphEntityList(new ArrayList<>());
            questionEntity.setSubQuestionEntityList(new ArrayList<>());

            partQuestionEntity.getQuestionEntityList().add(questionEntity);

            if (!questionDto.getFileImageDtoList().isEmpty()) {
                //transform fileImageDtoToEntity
                for (FileImageDto fileImageDto : questionDto.getFileImageDtoList()) {
                    FileImageEntity fileImageEntity = fileImageTransform.convertFileImageDtoToEntity(fileImageDto);
                    questionEntity.getFileImageEntityList().add(fileImageEntity);
                }
            }

            if (!questionDto.getParagraphDtoList().isEmpty()) {
                //transform paragrapDtoToEntity
                for (ParagraphDto paragraphDto : questionDto.getParagraphDtoList()) {
                    ParagraphEntity paragraphEntity = this.paragraphTransform.convertParagraphDtoToEntity(paragraphDto);
                    questionEntity.getParagraphEntityList().add(paragraphEntity);
                }
            }
            if (!questionDto.getSubQuestionDtoList().isEmpty()) {
                //transform subQuestionDtoToEntity
                for (SubQuestionDto subQuestionDto : questionDto.getSubQuestionDtoList()) {
                    SubQuestionEntity subQuestionEntity = this.subQuestionTransform.convertSubQuestionDtoToEntity(subQuestionDto);
                    subQuestionEntity.setSentenceEntityList(new ArrayList<>());
                    questionEntity.getSubQuestionEntityList().add(subQuestionEntity);
                    if (!subQuestionDto.getSentenceDtoList().isEmpty()) {
                        //transform sentenceDtoToEntity
                        for (SentenceDto sentenceDto : subQuestionDto.getSentenceDtoList()) {
                            SentenceEntity sentenceEntity = this.sentenceTransform.convertSentenceDtoToEntity(sentenceDto);
                            subQuestionEntity.getSentenceEntityList().add(sentenceEntity);
                        }
                    }
                }
            }


        }

        logger.info("End transformPartQuestionDtoToEntity with result :"+partQuestionEntity);

        return partQuestionEntity;


    }
}
