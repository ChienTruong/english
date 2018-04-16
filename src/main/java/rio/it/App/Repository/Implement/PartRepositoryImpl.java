package rio.it.App.Repository.Implement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import rio.it.App.Entity.PartEntity;
import rio.it.App.Repository.PartRepository;

import javax.persistence.TypedQuery;

/**
 * Created by chien on 08/04/2018.
 */
@Repository
public class PartRepositoryImpl extends GenericRepositoryImpl<PartEntity, Long> implements PartRepository {
    private Logger logger = LoggerFactory.getLogger(PartRepository.class);
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
