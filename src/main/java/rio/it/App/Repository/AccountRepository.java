package rio.it.App.Repository;

import rio.it.App.Entity.AccountEntity;

public interface AccountRepository extends GenericRepository<AccountEntity,Long>{
    AccountEntity findByName(String email);
}
