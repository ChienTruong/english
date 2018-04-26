package rio.it.App.Dao;

import rio.it.App.Entity.AccountEntity;

public interface AccountDao extends GenericDao<AccountEntity,Long> {

    AccountEntity findByEmail(String email);
}
