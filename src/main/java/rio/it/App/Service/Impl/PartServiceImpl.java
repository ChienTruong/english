package rio.it.App.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rio.it.App.Model.PartModel;
import rio.it.App.Repository.PartRepository;
import rio.it.App.Service.PartService;

/**
 * Created by chien on 10/04/2018.
 */
@Service
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
}
