package rio.it.App.Repository.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rio.it.App.Dao.PartDao;
import rio.it.App.Dao.PartQuestionDao;
import rio.it.App.Entity.PartEntity;
import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.HandleMultipartfile.HandleFile;
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
    private HandleFile handleFile;

    @Autowired
    public PartQuestionRepositoryImpl(PartQuestionTransform partQuestionTransform, PartQuestionDao partQuestionDao, PartDao partDao, HandleFile handleFile) {
        this.partQuestionTransform = partQuestionTransform;
        this.partQuestionDao = partQuestionDao;
        this.partDao = partDao;
        this.handleFile = handleFile;
    }

    @Override
    public void save(PartQuestionModel partQuestionModel) {
        // convert to entity from model
        PartQuestionEntity partQuestionEntity = this.partQuestionTransform.convertPartQuestionModelToEntity(partQuestionModel);
        // find part entity related with part question entity
        PartEntity partEntity = this.partDao.findByName(partQuestionModel.getNamePart());
        partQuestionEntity.setPartEntity(partEntity);
        // some process with file mp3 and file image
        handleFile.dosomething(partQuestionEntity, partQuestionModel);
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
}
