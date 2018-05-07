package rio.it.App.Service;

import java.util.Map;
import java.util.UUID;

/**
 * Created by chien on 29/04/2018.
 */
public interface AccountService {

    Map<UUID, Integer> getHistoryOfUser(String emailUser, String namePart);
}
