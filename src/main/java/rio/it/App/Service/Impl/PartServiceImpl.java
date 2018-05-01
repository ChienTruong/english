package rio.it.App.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rio.it.App.Model.PartModel;
import rio.it.App.Repository.PartRepository;
import rio.it.App.Service.PartService;

import java.util.List;

/**
 * Created by chien on 10/04/2018.
 */
@Service
@Transactional
public class PartServiceImpl implements PartService {

    private PartRepository partRepository;

    @Autowired
    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public boolean checkExist(String namePart) {
        PartModel partModel = this.findByName(namePart);
        if (partModel != null) {
            return true;
        }
        return false;
    }

    @Override
    public PartModel findByName(String namePart) {
        PartModel partModel = partRepository.findByName(namePart);
        return partModel;
    }

    @Override
    public PartModel findById(Long idPartQuestion) {
        return null;
    }

    @Override
    public List<Long> getAllIdOfListPartQuestion(String namePart) {
        return this.partRepository.getListIdOfPartQuestionByNamePart(namePart);
    }
}
