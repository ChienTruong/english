package rio.it.App.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Repository.PartQuestionRepository;
import rio.it.App.Service.PartQuestionService;

/**
 * Created by chien on 10/04/2018.
 */
@Service
public class PartQuestionServiceImpl implements PartQuestionService {

    private PartQuestionRepository partQuestionRepository;

    @Autowired
    public PartQuestionServiceImpl(PartQuestionRepository partQuestionRepository) {
        this.partQuestionRepository = partQuestionRepository;
    }

    @Override
    public boolean createPartQuestionDto(PartQuestionDto partQuestionDto) {
        return false;
    }
}
