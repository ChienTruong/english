package rio.it.App.BusinessLogic.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import rio.it.App.BusinessLogic.PartQuestionBl;
import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Service.AccountService;
import rio.it.App.Service.PartQuestionService;
import rio.it.App.Service.PartService;
import rio.it.App.Util.FactoryVerifyPartQuestion;
import rio.it.App.Util.PartEnum;
import rio.it.App.Util.VerifyPartQuestion;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by chien on 23/04/2018.
 */
@Component
public class PartQuestionBlImpl implements PartQuestionBl {

    private AccountService accountService;
    private PartService partService;
    private PartQuestionService partQuestionService;
    private FactoryVerifyPartQuestion factoryVerifyPartQuestion;

    private VerifyPartQuestion verifyPartQuestion;

    @Autowired
    public PartQuestionBlImpl(AccountService accountService, PartService partService, PartQuestionService partQuestionService, FactoryVerifyPartQuestion factoryVerifyPartQuestion) {
        this.accountService = accountService;
        this.partService = partService;
        this.partQuestionService = partQuestionService;
        this.factoryVerifyPartQuestion = factoryVerifyPartQuestion;
    }

    /**
     * Create new part question entity
     *
     * @param partQuestionModel
     * @param name
     * @param authorities       @return Step 1: get class verify match with partQuestion
     * @Note_11/04/18_Chien: view class factoryVerifyPartQuestion to know information of this class
     * Step 2: it will be verified by class verifyPartQuestion
     * Step 3: save this object
     */
    @Override
    public boolean createPartQuestionDto(PartQuestionModel partQuestionModel, String name, Collection<? extends GrantedAuthority> authorities) {
        // find part is here
        if (!partQuestionModel.getNamePart().isEmpty()
                && partService.checkExist(partQuestionModel.getNamePart())) {
            PartEnum part = getPartEnum(partQuestionModel.getNamePart());
            this.verifyPartQuestion = this.factoryVerifyPartQuestion.getVerify(part);
            boolean verifyResult = this.verifyPartQuestion.verify(partQuestionModel);
            if (verifyResult) {
                this.partQuestionService.save(partQuestionModel);
            }
        }
        return false;
    }

    /**
     * this method will return part enum equal with part name
     *
     * @param partName
     * @return
     */
    private PartEnum getPartEnum(String partName) {
        return Arrays.stream(PartEnum.values()).filter(part -> part.toString().endsWith(partName)).findFirst().get();
    }
}
