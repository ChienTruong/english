package rio.it.App.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
public class PartQuestionServiceImpl implements PartQuestionService {

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
        if (!partQuestionDto.getNamePart().isEmpty()) {
            PartEntity partEntity = this.partRepository.findByName(partQuestionDto.getNamePart());
            if (partEntity == null) {
                return false;
            }
            PartEnum partEnum = getPartEnum(partEntity.getPartName());
            this.verifyPartQuestion = this.factoryVerifyPartQuestion.getVerify(partEnum);
            boolean verifyResult = this.verifyPartQuestion.verify(partQuestionDto);
            if (verifyResult) {
                // do something
                // step1. transfer entity

                // step2. process another

                // step3. give entity to repository

            }
        }
        return false;
    }

    /**
     *
     * @param partName
     * @return
     */
    private PartEnum getPartEnum(String partName) {
        return Arrays.stream(PartEnum.values()).filter(part -> partName.toUpperCase().contains(part.name())).findFirst().get();
    }
}
