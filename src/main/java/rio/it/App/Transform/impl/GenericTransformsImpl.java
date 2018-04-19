package rio.it.App.Transform.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rio.it.App.Dto.*;
import rio.it.App.Entity.*;
import rio.it.App.Repository.AccountRepository;
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
    private AccountTransform accountTransform;
    private AccountRepository accountRepository;
    private   Logger logger = LoggerFactory.getLogger(GenericTransformsImpl.class);

    @Autowired
    public GenericTransformsImpl(AccountRepository accountRepository,AccountTransform accountTransform, PartQuestionTransform partQuestionTransform, QuestionTransform questionTransform, SubQuestionTransform subQuestionTransform, ParagraphTransform paragraphTransform, SentenceTransform sentenceTransform, FileImageTransform fileImageTransform) {
        this.partQuestionTransform = partQuestionTransform;
        this.questionTransform = questionTransform;
        this.subQuestionTransform = subQuestionTransform;
        this.paragraphTransform = paragraphTransform;
        this.sentenceTransform = sentenceTransform;
        this.fileImageTransform = fileImageTransform;
        this.accountTransform = accountTransform;
        this.accountRepository = accountRepository;
    }

    public PartQuestionEntity transformPartQuestionDtoToEntity(PartQuestionDto partQuestionDto) {


        logger.info("Begin transformPartQuestionDtoToEntity with condition :"+partQuestionDto);
        PartQuestionEntity partQuestionEntity = this.partQuestionTransform.convertPartQuestionDtoToEntity(partQuestionDto);
        // add accountEntity in partQuestionEntity
        //AccountEntity accountEntity =  accountRepository.findByName(partQuestionDto.getAccountDto().getEmail());
        //partQuestionEntity.setAccountEntity(accountEntity);
        // new ArrayList<>() for QuestionEntityList in partQuestionEntity
        partQuestionEntity.setQuestionEntityList(new ArrayList<>());
         // transform questionDtoToEntity
        for (QuestionDto questionDto : partQuestionDto.getQuestionDtoList()) {

            QuestionEntity questionEntity = this.questionTransform.convertQuestionDtoToEntity(questionDto);
            questionEntity.setFileImageEntityList(new ArrayList<>());
            questionEntity.setParagraphEntityList(new ArrayList<>());
            questionEntity.setSubQuestionEntityList(new ArrayList<>());
            partQuestionEntity.getQuestionEntityList().add(questionEntity);
            questionEntity.setPartQuestionEntity(partQuestionEntity);

            if (!questionDto.getFileImageDtoList().isEmpty()) {
                //transform fileImageDtoToEntity
                for (FileImageDto fileImageDto : questionDto.getFileImageDtoList()) {
                    FileImageEntity fileImageEntity = fileImageTransform.convertFileImageDtoToEntity(fileImageDto);
                    questionEntity.getFileImageEntityList().add(fileImageEntity);
                    fileImageEntity.setQuestionEntity(questionEntity);
                }
            }

            if (!questionDto.getParagraphDtoList().isEmpty()) {
                //transform paragrapDtoToEntity
                for (ParagraphDto paragraphDto : questionDto.getParagraphDtoList()) {
                    ParagraphEntity paragraphEntity = this.paragraphTransform.convertParagraphDtoToEntity(paragraphDto);
                    questionEntity.getParagraphEntityList().add(paragraphEntity);
                    paragraphEntity.setQuestionEntity(questionEntity);
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
                            sentenceEntity.setSubQuestionEntity(subQuestionEntity);
                        }
                    }
                    subQuestionEntity.setQuestionEntity(questionEntity);
                }
            }

        }
//        logger.info("End transformPartQuestionDtoToEntity with result :"+partQuestionEntity);

        return partQuestionEntity;


    }
}
