package rio.it.App.Service;

import rio.it.App.Model.PartModel;

/**
 * Created by chien on 10/04/2018.
 */
public interface PartService {

    boolean checkExist(String namePart);

    PartModel findByName(String namePart);
}
