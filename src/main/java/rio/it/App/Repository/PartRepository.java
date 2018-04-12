package rio.it.App.Repository;

import rio.it.App.Entity.PartEntity;

/**
 * Created by chien on 08/04/2018.
 */
public interface PartRepository extends GenericRepository<PartEntity, Long> {
    PartEntity findByName(String namePart);
}
