package rio.it.App.Repository.Impl;

import org.springframework.stereotype.Repository;
import rio.it.App.Dao.PartDao;
import rio.it.App.Dao.PartQuestionDao;
import rio.it.App.Entity.PartEntity;
import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Repository.PartQuestionRepository;
import rio.it.App.Transform.PartQuestionTransform;

/**
 * Created by chien on 23/04/2018.
 */
@Repository
public class PartQuestionRepositoryImpl implements PartQuestionRepository {

    private PartQuestionTransform partQuestionTransform;
    private PartQuestionDao partQuestionDao;
    private PartDao partDao;

    public PartQuestionRepositoryImpl(PartQuestionTransform partQuestionTransform, PartQuestionDao partQuestionDao, PartDao partDao) {
        this.partQuestionTransform = partQuestionTransform;
        this.partQuestionDao = partQuestionDao;
        this.partDao = partDao;
    }

    @Override
    public void save(PartQuestionModel partQuestionModel) {
        PartQuestionEntity partQuestionEntity = this.partQuestionTransform.convertPartQuestionModelToEntity(partQuestionModel);
        PartEntity partEntity = this.partDao.findByName(partQuestionModel.getNamePart());
        partQuestionEntity.setPartEntity(partEntity);
        partQuestionDao.save(partQuestionEntity);
    }

    @Override
    public PartQuestionModel findById(Long idOfPartQuestion) {
        PartQuestionEntity partQuestionEntity = this.partQuestionDao.findOne(idOfPartQuestion);
        PartQuestionModel partQuestionModel = this.partQuestionTransform.convertPartQuestionEntityToModel(partQuestionEntity);
        return partQuestionModel;
    }
}
