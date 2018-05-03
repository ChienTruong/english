package rio.it.App.Repository.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rio.it.App.Dao.PartDao;
import rio.it.App.Entity.PartEntity;
import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.Model.PartModel;
import rio.it.App.Repository.PartRepository;
import rio.it.App.Transform.PartTransform;

import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println("@@@@@@@@@@@@");
        PartModel partModel = partTransform.convertPartEntityToModel(partEntity);
        return partModel;
    }

    @Override
    public List<Long> getListIdOfPartQuestionByNamePart(String namePart) {
        PartEntity partEntity = partDao.findByName(namePart);
        return partEntity.getPartQuestionEntityList()
                .stream().map(PartQuestionEntity::getId)
                .collect(Collectors.toList());
    }
}
