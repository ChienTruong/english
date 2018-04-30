package rio.it.App.Service;

import java.util.Map;

/**
 * Created by chien on 29/04/2018.
 */
public interface AccountService {

    Map<Long, Integer> getHistoryOfUser(String emailUser,String namePart);
}
