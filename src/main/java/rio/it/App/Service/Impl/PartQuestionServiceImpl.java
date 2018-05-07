package rio.it.App.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Repository.Impl.PartQuestionRepositoryImpl;
import rio.it.App.Repository.PartQuestionRepository;
import rio.it.App.Service.PartQuestionService;

import java.util.UUID;


/**
 * Created by chien on 10/04/2018.
 */
@Service
@Transactional
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
    public PartQuestionModel getByUUID(UUID uuidPartQuestion) {
        return null;
    }

    @Override
    public boolean checkExist(Long partQuestionId) {
        if (this.partQuestionRepository.findById(partQuestionId) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void update(Long partQuestionId, PartQuestionModel partQuestionModel) {
        this.partQuestionRepository.update(partQuestionId, partQuestionModel);
    }
}
