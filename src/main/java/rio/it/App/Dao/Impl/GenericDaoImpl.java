package rio.it.App.Dao.Impl;

import rio.it.App.Dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by chien on 06/04/2018.
 */
public abstract class GenericDaoImpl<E, ID> implements GenericDao<E, ID> {

    private Class<E> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;


    public GenericDaoImpl() {
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) parameterizedType.getActualTypeArguments()[0];
    }

    @Override
    public void save(E e) {
        this.entityManager.persist(e);
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
        E e = this.entityManager.find(this.entityClass, id);
        return e;
    }

    @Override
    public List<E> findAll() {
        String sql = "FROM " + this.entityClass.getSimpleName();
        return this.entityManager.createQuery(sql, this.entityClass).getResultList();
    }

}
