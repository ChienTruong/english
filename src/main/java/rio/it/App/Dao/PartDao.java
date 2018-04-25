package rio.it.App.Dao;

import rio.it.App.Entity.PartEntity;

/**
 * Created by chien on 08/04/2018.
 */
public interface PartDao extends GenericDao<PartEntity, Long> {
    PartEntity findByName(String namePart);
}
