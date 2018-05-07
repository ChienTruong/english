package rio.it.App.Repository.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rio.it.App.Dao.PartDao;
import rio.it.App.Dao.PartQuestionDao;
import rio.it.App.Entity.PartEntity;
import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.HandleMultipartfile.HandleFileModelToEntity;
import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Repository.PartQuestionRepository;
import rio.it.App.Transform.ModelTransformEntity;
import rio.it.App.Transform.PartQuestionTransform;

import java.util.UUID;

/**
 * Created by chien on 23/04/2018.
 */
@Repository
public class PartQuestionRepositoryImpl implements PartQuestionRepository {

    private PartQuestionTransform partQuestionTransform;
    private PartQuestionDao partQuestionDao;
    private PartDao partDao;
    private HandleFileModelToEntity handleFile;
    private ModelTransformEntity genericTransform;
    @Autowired
    public PartQuestionRepositoryImpl(PartQuestionTransform partQuestionTransform, PartQuestionDao partQuestionDao, PartDao partDao, HandleFileModelToEntity handleFile, ModelTransformEntity genericTransform) {
        this.partQuestionTransform = partQuestionTransform;
        this.partQuestionDao = partQuestionDao;
        this.partDao = partDao;
        this.handleFile = handleFile;
        this.genericTransform = genericTransform;
    }

    @Override
    public void save(PartQuestionModel partQuestionModel) {
        // convert to entity from model
        PartQuestionEntity partQuestionEntity = this.genericTransform.transformPartQuestionModelToEntity(partQuestionModel);
        // find part entity related with part question entity
        PartEntity partEntity = this.partDao.findByName(partQuestionModel.getNamePart());
        partQuestionEntity.setPartEntity(partEntity);
        // some process with file mp3 and file image
        handleFile.HandleFileModelToEntity(partQuestionEntity, partQuestionModel);
        System.out.println("File Mp3   " + partQuestionEntity.getPathFileMp3());
        // do save
        partQuestionDao.save(partQuestionEntity);
    }

    @Override
    public PartQuestionModel findById(Long idOfPartQuestion) {
        PartQuestionEntity partQuestionEntity = this.partQuestionDao.findOne(idOfPartQuestion);
        PartQuestionModel partQuestionModel = this.partQuestionTransform.convertPartQuestionEntityToModel(partQuestionEntity);
        return partQuestionModel;
    }

    @Override
    public void update(Long partQuestionId, PartQuestionModel partQuestionModel) {
        PartQuestionEntity partQuestionEntity = this.genericTransform.transformPartQuestionModelToEntity(partQuestionModel);
      //partQuestionEntity.setPartQuestionId(partQuestionId);
        this.handleFile.HandleFileModelToEntity(partQuestionEntity, partQuestionModel);
        partQuestionDao.update(partQuestionEntity);
    }

    @Override
    public PartQuestionModel findByUUID(UUID uuidPartQuestion) {
        return null;
    }
}
