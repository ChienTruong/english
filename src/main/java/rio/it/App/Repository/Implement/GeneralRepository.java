package rio.it.App.Repository.Implement;

import rio.it.App.Repository.General;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by chien on 06/04/2018.
 */
public abstract class GeneralRepository<E, ID> implements General<E, ID> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(E e) {
        this.entityManager.persist(e);
        return this.entityManager.contains(e);
    }

    @Override
    public boolean delete(E e) {
        this.entityManager.remove(e);
        return this.entityManager.contains(e);
    }

    @Override
    public boolean update(E e) {
        this.entityManager.merge(e);
        return this.entityManager.contains(e);
    }

    @Override
    public E findOne(ID id) {
        E e = this.entityManager.find(this.getSimpleNameOfEntity(), id);
        return e;
    }

    @Override
    public List<E> findAll() {
        String sql = "FROM " + this.getSimpleNameOfEntity().getSimpleName();
        return this.entityManager.createQuery(sql, this.getSimpleNameOfEntity()).getResultList();
    }

    protected abstract Class<E> getSimpleNameOfEntity();
}
