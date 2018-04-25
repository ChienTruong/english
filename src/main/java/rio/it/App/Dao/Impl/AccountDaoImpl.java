package rio.it.App.Dao.Impl;

import org.springframework.stereotype.Repository;
import rio.it.App.Entity.AccountEntity;
import rio.it.App.Dao.AccountDao;
@Repository
public class AccountDaoImpl extends GenericDaoImpl<AccountEntity,Long> implements AccountDao {
    @Override
    public AccountEntity findByName(String email) {
        return null;
    }
}
