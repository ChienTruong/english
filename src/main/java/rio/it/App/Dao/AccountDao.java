package rio.it.App.Dao;

import rio.it.App.Entity.AccountEntity;
import rio.it.App.Model.SomeObject;

import java.util.Map;

public interface AccountDao extends GenericDao<AccountEntity,Long> {

    AccountEntity findByEmail(String email);

}
