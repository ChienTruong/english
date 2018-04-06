package rio.it.App.Repository;

import java.util.List;

/**
 * Created by chien on 06/04/2018.
 */
public interface General<E, ID> {

    boolean save(E e);

    boolean delete(E e);

    boolean update(E e);

    E findOne(ID id);

    List<E> findAll();
}
