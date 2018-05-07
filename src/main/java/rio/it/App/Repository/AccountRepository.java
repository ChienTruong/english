package rio.it.App.Repository;

import rio.it.App.Model.AccountModel;
import rio.it.App.Model.SomeObject;

import java.util.Map;
import java.util.UUID;

public interface AccountRepository {

    AccountModel findOne(Long idAccount);

    AccountModel findByName(String email);

    Map<UUID, SomeObject> getHistoryOfAccount(String email);

}
