package rio.it.App.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Repository.Impl.PartQuestionRepositoryImpl;
import rio.it.App.Repository.PartQuestionRepository;
import rio.it.App.Service.PartQuestionService;

/**
 * Created by chien on 10/04/2018.
 */
@Service
public class PartQuestionServiceImpl implements PartQuestionService {

    private PartQuestionRepository partQuestionRepository;

    @Autowired
    public PartQuestionServiceImpl(PartQuestionRepositoryImpl partQuestionRepository) {
        this.partQuestionRepository = partQuestionRepository;
    }

    @Override
    public void save(PartQuestionModel partQuestionModel) {
        partQuestionRepository.save(partQuestionModel);
    }

    @Override
    public PartQuestionModel getById(Long idOfPartQuestion) {
        this.partQuestionRepository.findById(idOfPartQuestion);
        return null;
    }
}
