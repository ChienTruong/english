package rio.it.App.Repository.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rio.it.App.Dao.AccountDao;
import rio.it.App.Dao.PartDao;
import rio.it.App.Dao.PartQuestionDao;
import rio.it.App.Entity.AccountEntity;
import rio.it.App.Entity.PartEntity;
import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.Model.PartModel;
import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Repository.PartRepository;
import rio.it.App.Transform.EntityTransformToModel;
import rio.it.App.Transform.ModelTransformEntity;
import rio.it.App.Transform.PartQuestionTransform;
import rio.it.App.Transform.PartTransform;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by chien on 23/04/2018.
 */
@Repository
public class PartRepositoryImpl implements PartRepository {

    private PartDao partDao;
    private PartTransform partTransform;
    private PartQuestionDao partQuestionDao;
    private AccountDao accountDao;
    private EntityTransformToModel entityTransformToModel;

    @Autowired
    public PartRepositoryImpl(PartDao partDao, PartTransform partTransform, PartQuestionDao partQuestionDao, AccountDao accountDao, EntityTransformToModel entityTransformToModel) {
        this.partDao = partDao;
        this.partTransform = partTransform;
        this.partQuestionDao = partQuestionDao;
        this.accountDao = accountDao;
        this.entityTransformToModel = entityTransformToModel;
    }

    @Override
    public List<PartQuestionModel> getAllPartQuestionModelThisAccount(String namePart, String email) {

        AccountEntity accountEntity =  accountDao.findByEmail(email);
        List<PartQuestionEntity> partQuestionEntityList =  accountEntity.getPartQuestionEntities();
        List<PartQuestionModel> questionModelList = new ArrayList<>();

        partQuestionEntityList.forEach(partQuestionEntity -> {
            if (partQuestionEntity.getPartEntity().getPartName().equalsIgnoreCase(namePart)){
                PartQuestionModel partQuestionModel =  entityTransformToModel.transformPartQuestionEntityToModel(partQuestionEntity);
                questionModelList.add(partQuestionModel);
            }

        });
        return questionModelList;
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
