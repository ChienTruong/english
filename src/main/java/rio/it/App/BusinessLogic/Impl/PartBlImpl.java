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

    @Autowired
    public PartBlImpl(PartService partService, PartQuestionService partQuestionService) {
        this.partService = partService;
        this.partQuestionService = partQuestionService;
    }

    @Override
    public PartQuestionModel getPartQuestionRandom(String namePart) {
        if (namePart != null) {
            if (this.partService.checkExist(namePart)) {
                List<Long> idPartQuestionList = this.partService.getAllIdOfListPartQuestion(namePart);
                int sizeOfPartQuestionList = idPartQuestionList.size();
                Random random = new Random();
                int index = random.nextInt(sizeOfPartQuestionList) + 1;
                Long idOfPartQuestion = idPartQuestionList.get(index);
                this.partQuestionService.getById(idOfPartQuestion);
            }
        }
        return null;
    }
}
