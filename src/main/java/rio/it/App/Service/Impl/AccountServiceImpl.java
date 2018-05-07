package rio.it.App.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rio.it.App.Entity.HistoryEntity;
import rio.it.App.Model.AccountModel;
import rio.it.App.Model.SomeObject;
import rio.it.App.Repository.AccountRepository;
import rio.it.App.Service.AccountService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by chien on 29/04/2018.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Map<UUID, Integer> getHistoryOfUser(String emailUser, String namePart) {
        Map<UUID, Integer> mapsevice = new HashMap<>();
        if (emailUser != null && namePart != null) {

            Map<UUID, SomeObject> mapRepository = this.accountRepository.getHistoryOfAccount(emailUser);
            mapRepository.forEach((aLong, someObject) -> {
                if (someObject.getNamePart().equalsIgnoreCase(namePart)) {
                    mapsevice.put(aLong, someObject.getNumComplete());
                }
            });
        }
        return mapsevice;
    }
}
