package rio.it.App.Dao;

import rio.it.App.Entity.PartQuestionEntity;

import java.util.UUID;

/**
 * Created by chien on 08/04/2018.
 */
public interface PartQuestionDao extends GenericDao<PartQuestionEntity, Long> {
    public PartQuestionEntity findByUUID(UUID uuidPartQuestion);
}
