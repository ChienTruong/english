package rio.it.App.Dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import rio.it.App.Entity.AccountEntity;
import rio.it.App.Dao.AccountDao;
import javax.persistence.TypedQuery;

@Repository
public class AccountDaoImpl extends GenericDaoImpl<AccountEntity,Long> implements AccountDao {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public AccountEntity findByEmail(String email){

        String sql = "SELECT a FROM " + AccountEntity.class.getSimpleName() + " AS a WHERE a.email = :email";
        TypedQuery<AccountEntity> query = this.entityManager.createQuery(sql, AccountEntity.class);
        return query.getSingleResult();


    }
}
