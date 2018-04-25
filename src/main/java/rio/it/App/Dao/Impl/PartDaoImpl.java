package rio.it.App.Dao.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import rio.it.App.Entity.PartEntity;
import rio.it.App.Dao.PartDao;

import javax.persistence.TypedQuery;

/**
 * Created by chien on 08/04/2018.
 */
@Repository
public class PartDaoImpl extends GenericDaoImpl<PartEntity, Long> implements PartDao {
    private Logger logger = LoggerFactory.getLogger(PartDao.class);
    @Override
    public PartEntity findByName(String namePart) {
        System.out.println("######  "+namePart);
        logger.info("Begin findByName with Prerequisite: "+namePart);
        String selection = "SELECT p FROM " + PartEntity.class.getSimpleName() + " AS p WHERE UPPER(p.partName) LIKE :namePart";
        TypedQuery<PartEntity> query = this.entityManager.createQuery(selection, PartEntity.class);
        query.setParameter("namePart", '%' + namePart.toUpperCase() + '%');
        query.setMaxResults(1);
        query.setFirstResult(0);
        logger.info("End findByName with result: "+query.getResultList());
        return query.getSingleResult();
    }
}
