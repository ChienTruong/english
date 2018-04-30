package rio.it.App.BusinessLogic.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rio.it.App.BusinessLogic.PartBl;
import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Service.AccountService;
import rio.it.App.Service.PartQuestionService;
import rio.it.App.Service.PartService;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by chien on 24/04/2018.
 */
@Component
public class PartBlImpl implements PartBl {

    private static final Logger LOGGER = LoggerFactory.getLogger(PartBlImpl.class);

    private AccountService accountService;
    private PartService partService;
    private PartQuestionService partQuestionService;
    private Random random;

    @Autowired
    public PartBlImpl(AccountService accountService, PartService partService, PartQuestionService partQuestionService) {
        this.accountService = accountService;
        this.partService = partService;
        this.partQuestionService = partQuestionService;
        this.random = new Random();
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    /**
     * @param namePart
     * @param emailUser
     * @return
     */
    @Override
    public PartQuestionModel getPartQuestionRandom(final String namePart,
                                                   final String emailUser) {
        // verify null
        if (namePart != null
                && emailUser != null) {
            // check exist part model
            if (this.partService.checkExist(namePart)) {
                // get all part question belong name part
                List<Long> idPartQuestionList = this.partService.getAllIdOfListPartQuestion(namePart);
                // get history of user
                // key -> long -> part question id
                // value -> integer -> num of completion of part question
                Map<Long, Integer> mapCountHistory = this.accountService.getHistoryOfUser(emailUser,namePart);
                // get size of part question is children of part
                int sizeOfPartQuestionList = idPartQuestionList.size();
                // get random index in list
                int index = this.makeRandomNumInteger(sizeOfPartQuestionList);
                // retrieve id of part question in list part
                Long idOfPartQuestion = idPartQuestionList.get(index);
                // if user don't do any test
                if (mapCountHistory == null) {
                    return this.partQuestionService.getById(idOfPartQuestion);
                }
                // user don't done all test belong test of this part
                if (!mapCountHistory.keySet().containsAll(idPartQuestionList)) {
                    // get part question of this part
                    while (true) {
                        if (!mapCountHistory.containsKey(idOfPartQuestion)) {
                            break;
                        }
                        index = this.makeRandomNumInteger(sizeOfPartQuestionList);
                        idOfPartQuestion = idPartQuestionList.get(index);
                    }
                } else {
                    // this case of user do times 12 on 10 part question this part name
                    // get list less than equal each other
                    int min = Integer.MAX_VALUE;
                    for (Map.Entry<Long, Integer> longIntegerEntry : mapCountHistory.entrySet()) {
                        if (longIntegerEntry.getValue() < min) {
                            min = longIntegerEntry.getValue();
                            idOfPartQuestion = longIntegerEntry.getKey();
                        }
                    }
                }
                return this.partQuestionService.getById(idOfPartQuestion);
            }
        }
        return null;
    }

    /**
     * random number index
     *
     * @param maxSize
     * @return
     */
    private int makeRandomNumInteger(int maxSize) {
        return this.random.nextInt(maxSize) + 1;
    }
}
