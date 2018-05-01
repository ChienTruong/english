package rio.it.App.Configuration.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import rio.it.App.Dao.AccountDao;
import rio.it.App.Entity.AccountEntity;
import rio.it.App.Entity.RoleEntity;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by chien on 26/04/2018.
 */
@Configuration
public class UserDetail implements UserDetailsService {

    private AccountDao accountDao;

    @Autowired
    public UserDetail(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * @ntoe find user for feature login of spring 5.
     * @param s
     * @return
     * @throws UsernameNotFoundException
     * @version spring 5.
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // find account
        AccountEntity accountEntity = accountDao.findByEmail(s);
        // make list role is granted
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>(0);
        if (accountEntity != null) {
            for (RoleEntity roleEntity : accountEntity.getRoleEntityList()) {
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roleEntity.getRole()));
            }
        }
        // create user
        UserDetails userDetails = new User(s, accountEntity.getPwd(), accountEntity.getEnable(),
                true, true, true, grantedAuthorities);
        return userDetails;
    }
}
