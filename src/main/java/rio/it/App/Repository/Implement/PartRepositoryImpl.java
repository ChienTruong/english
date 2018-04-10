package rio.it.App.Repository.Implement;

import org.springframework.stereotype.Repository;
import rio.it.App.Entity.PartEntity;
import rio.it.App.Repository.PartRepository;

/**
 * Created by chien on 08/04/2018.
 */
@Repository
public class PartRepositoryImpl extends GenericRepositoryImpl<PartEntity, Long> implements PartRepository {

}
