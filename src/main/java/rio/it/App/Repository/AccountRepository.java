package rio.it.App.Repository;

import org.springframework.stereotype.Component;
import rio.it.App.Model.AccountModel;
import rio.it.App.Model.SomeObject;

import java.util.Map;

@Component
public interface AccountRepository {

    AccountModel findOne(Long idAccount);
    AccountModel findByName(String email);

    Map<Long, SomeObject> getHistoryOfAccount(String email);

}
