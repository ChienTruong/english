package rio.it.App.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Repository.PartQuestionRepository;
import rio.it.App.Service.PartQuestionService;
import rio.it.App.Util.FactoryVerifyPartQuestion;
import rio.it.App.Util.Part;
import rio.it.App.Util.VerifyPartQuestion;

/**
 * Created by chien on 10/04/2018.
 */
@Service
public class PartQuestionServiceImpl implements PartQuestionService {

    private PartQuestionRepository partQuestionRepository;
    private FactoryVerifyPartQuestion factoryVerifyPartQuestion;
    private VerifyPartQuestion verifyPartQuestion;

    @Autowired
    public PartQuestionServiceImpl(PartQuestionRepository partQuestionRepository, FactoryVerifyPartQuestion factoryVerifyPartQuestion) {
        this.partQuestionRepository = partQuestionRepository;
        this.factoryVerifyPartQuestion = factoryVerifyPartQuestion;
    }

    /**
     * Create new part question entity
     *
     * @param partQuestionDto
     * @return Step 1: get class verify match with partQuestion
     * @Note_11/04/18_Chien: view class factoryVerifyPartQuestion to know information of this class
     * Step 2: it will be verified by class verifyPartQuestion
     * Step 3: ...
     */
    @Override
    public boolean createPartQuestionDto(PartQuestionDto partQuestionDto) {
        this.verifyPartQuestion = this.factoryVerifyPartQuestion.getVerify(Part.FIVE);
        boolean verifyResult = this.verifyPartQuestion.verify(partQuestionDto);
        if (verifyResult) {
            // dosomething
        }
        return false;
    }
}
