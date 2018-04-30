package rio.it.App.Service.Impl;

import org.springframework.stereotype.Service;
import rio.it.App.Service.AccountService;

import java.util.Map;

/**
 * Created by chien on 29/04/2018.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public Map<Long, Integer> getHistoryOfUser(String emailUser) {
        return null;
    }
}
