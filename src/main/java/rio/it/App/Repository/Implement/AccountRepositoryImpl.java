package rio.it.App.Repository.Implement;

import org.springframework.stereotype.Repository;
import rio.it.App.Entity.AccountEntity;
import rio.it.App.Repository.AccountRepository;
@Repository
public class AccountRepositoryImpl extends GenericRepositoryImpl<AccountEntity,Long> implements AccountRepository {
    @Override
    public AccountEntity findByName(String email) {
        return null;
    }
}
