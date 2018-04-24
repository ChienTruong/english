package rio.it.App.Repository.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rio.it.App.Dao.PartDao;
import rio.it.App.Entity.PartEntity;
import rio.it.App.Model.PartModel;
import rio.it.App.Repository.PartRepository;
import rio.it.App.Transform.PartTransform;

/**
 * Created by chien on 23/04/2018.
 */
@Repository
public class PartRepositoryImpl implements PartRepository {

    private PartDao partDao;
    private PartTransform partTransform;

    @Autowired
    public PartRepositoryImpl(PartDao partDao, PartTransform partTransform) {
        this.partDao = partDao;
        this.partTransform = partTransform;
    }

    @Override
    public PartModel findByName(String name) {
        PartEntity partEntity = partDao.findByName(name);
        PartModel partModel = partTransform.convertPartEntityToModel(partEntity);
        return partModel;
    }
}
