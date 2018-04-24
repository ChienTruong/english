package rio.it.App.Repository;

import rio.it.App.Model.PartModel;

/**
 * Created by chien on 23/04/2018.
 */
public interface PartRepository {

    PartModel findByName(String name);
}
