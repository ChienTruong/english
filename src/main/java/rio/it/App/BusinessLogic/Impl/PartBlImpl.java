package rio.it.App.BusinessLogic.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rio.it.App.BusinessLogic.PartBl;
import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Service.PartQuestionService;
import rio.it.App.Service.PartService;

import java.util.List;
import java.util.Random;

/**
 * Created by chien on 24/04/2018.
 */
@Component
public class PartBlImpl implements PartBl {

    private PartService partService;
    private PartQuestionService partQuestionService;
    private Random random;

    @Autowired
    public PartBlImpl(PartService partService, PartQuestionService partQuestionService) {
        this.partService = partService;
        this.partQuestionService = partQuestionService;
        this.random = new Random();
    }

    @Override
    public PartQuestionModel getPartQuestionRandom(String namePart) {
        if (namePart != null) {
            if (this.partService.checkExist(namePart)) {
                List<Long> idPartQuestionList = this.partService.getAllIdOfListPartQuestion(namePart);
                int sizeOfPartQuestionList = idPartQuestionList.size();
                int index = this.makeRandomNumInteger(sizeOfPartQuestionList);
                Long idOfPartQuestion = idPartQuestionList.get(index);
                return this.partQuestionService.getById(idOfPartQuestion);
            }
        }
        return null;
    }

    private int makeRandomNumInteger(int maxSize) {
        return this.random.nextInt(maxSize) + 1;
    }
}
