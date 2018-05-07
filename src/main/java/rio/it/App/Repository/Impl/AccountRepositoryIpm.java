package rio.it.App.Repository.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rio.it.App.Dao.AccountDao;
import rio.it.App.Entity.AccountEntity;
import rio.it.App.Entity.HistoryEntity;
import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.Model.AccountModel;
import rio.it.App.Model.SomeObject;
import rio.it.App.Repository.AccountRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class AccountRepositoryIpm implements AccountRepository {

    @Autowired
    private AccountDao accountDao;

    @Override
    public AccountModel findOne(Long idAccount) {
        return null;
    }

    @Override
    public AccountModel findByName(String email) {
        return null;
    }

    @Override
    public Map<UUID, SomeObject> getHistoryOfAccount(String email) {

        AccountEntity accountEntity = accountDao.findByEmail(email);

        Map<UUID, SomeObject> map = new HashMap<>();

        for (HistoryEntity historyEntity : accountEntity.getHistoryEntityList()) {

            PartQuestionEntity partQuestionEntity = historyEntity.getPk().getPartQuestionEntity();

            UUID idPartQuestion = partQuestionEntity.getUuid();

            if (!map.containsKey(idPartQuestion)) {
                SomeObject someObject = new SomeObject();
                someObject.setNamePart(partQuestionEntity.getPartEntity().getPartName());
                someObject.setNumComplete(0);
                map.put(idPartQuestion, someObject);
            }

            SomeObject someObject = map.get(idPartQuestion);
            int numCurrent = someObject.getNumComplete();
            someObject.setNumComplete(numCurrent + 1);
        }

        return map;
    }
}
