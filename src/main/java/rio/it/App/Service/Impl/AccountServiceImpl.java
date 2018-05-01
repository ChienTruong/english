package rio.it.App.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rio.it.App.Entity.HistoryEntity;
import rio.it.App.Model.AccountModel;
import rio.it.App.Model.SomeObject;
import rio.it.App.Repository.AccountRepository;
import rio.it.App.Service.AccountService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by chien on 29/04/2018.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Map<Long, Integer> getHistoryOfUser(String emailUser, String namePart) {
        if(emailUser != null && namePart != null){
            Map<Long, SomeObject> map = this.accountRepository.getHistoryOfAccount(emailUser);
        }
        return null;
    }
}
