package rio.it.App.Service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Entity.PartEntity;
import rio.it.App.Repository.PartQuestionRepository;
import rio.it.App.Repository.PartRepository;
import rio.it.App.Service.PartQuestionService;
import rio.it.App.Util.FactoryVerifyPartQuestion;
import rio.it.App.Util.PartEnum;
import rio.it.App.Util.VerifyPartQuestion;

import java.util.Arrays;

/**
 * Created by chien on 10/04/2018.
 */
@Service
@Transactional
public class PartQuestionServiceImpl implements PartQuestionService {
    private Logger logger = LoggerFactory.getLogger(PartQuestionServiceImpl.class);
    private PartQuestionRepository partQuestionRepository;
    private PartRepository partRepository;
    private FactoryVerifyPartQuestion factoryVerifyPartQuestion;
    private VerifyPartQuestion verifyPartQuestion;

    @Autowired
    public PartQuestionServiceImpl(PartQuestionRepository partQuestionRepository, PartRepository partRepository, FactoryVerifyPartQuestion factoryVerifyPartQuestion) {
        this.partQuestionRepository = partQuestionRepository;
        this.partRepository = partRepository;
        this.factoryVerifyPartQuestion = factoryVerifyPartQuestion;
    }

    /**
     * Create new part question entity
     *
     * @param partQuestionDto
     * @return Step 1: get class verify match with partQuestion
     * @Note_11/04/18_Chien: view class factoryVerifyPartQuestion to know information of this class
     * Step 2: it will be verified by class verifyPartQuestion
     * Step 3: transfer entity
     * Step 4: process another function
     * Step 5: give entity to repository
     */
    @Override
    public boolean createPartQuestionDto(PartQuestionDto partQuestionDto) {
        // find part is here
        PartEntity partEntity = null;
        PartEnum partEnum = null;
        logger.info("Begin createPartQuestionDto with condition: "+partQuestionDto);
        try {
            if (!partQuestionDto.getNamePart().isEmpty()) {
                partEntity = this.partRepository.findByName(partQuestionDto.getNamePart());
                if (partEntity == null) {
                    return false;
                }
                partEnum = getPartEnum(partEntity.getPartName());
                this.verifyPartQuestion = this.factoryVerifyPartQuestion.getVerify(partEnum);
                boolean verifyResult = this.verifyPartQuestion.verify(partQuestionDto);
                if (verifyResult) {
                    // do something
                    // step1. transfer entity

                    // step2. process another

                    // step3. give entity to repository

                }
            }
        }catch (Exception e){
            logger.info("Error createPartQuestionDto: "+e);
        }

        return false;
    }

    /**
     * @param partName
     * @return
     */
    private PartEnum getPartEnum(String partName) {
        return Arrays.stream(PartEnum.values()).filter(part -> partName.toUpperCase().contains(part.name())).findFirst().get();
    }
}
