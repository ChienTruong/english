package rio.it.App.Dao.Impl;

import org.springframework.stereotype.Repository;
import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.Dao.PartQuestionDao;

import javax.persistence.TypedQuery;
import java.util.UUID;

/**
 * Created by chien on 08/04/2018.
 */
@Repository
public class PartQuestionDaoImpl extends GenericDaoImpl<PartQuestionEntity, Long> implements PartQuestionDao {

    @Override
    public PartQuestionEntity findByUUID(UUID uuidPartQuestion) {
        String sql = "FROM " + PartQuestionEntity.class.getSimpleName() + " AS q WHERE q.uuid = :uuid";
        TypedQuery<PartQuestionEntity> query = this.entityManager.createQuery(sql, PartQuestionEntity.class);
        query.setParameter("uuid", uuidPartQuestion);
        query.setFirstResult(0);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
