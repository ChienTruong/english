package rio.it.App.Configuration.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * Created by chien on 26/04/2018.
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetail userDetail;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * @note load user of database
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("admin").password("admin").roles("ADMIN")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("user").password("user").roles("USER");
        auth.userDetailsService(userDetail).passwordEncoder(bCryptPasswordEncoder);
    }

    /**
     * @note some config of spring security
     * @param http
     * @throws Exception
     * document reference: https://docs.spring.io/spring-security/site/docs/5.0.5.BUILD-SNAPSHOT/reference/htmlsingle/
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login", "/h2-console/**")
                .permitAll();
        http
                .authorizeRequests()
                .antMatchers("/api/**")
                .authenticated();
        http
                .authorizeRequests()
                .antMatchers("/admin")
                .hasRole("ADMIN");
        http
                .exceptionHandling()
                .accessDeniedPage("/403");
        // part
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/part/*")
                .authenticated();
        // login
        http
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login?error")
                .usernameParameter("email")
                .passwordParameter("pwd");
        // logout
        http
                .logout()
                .logoutSuccessUrl("/login?logout");
        // setting for h2 database
        http
                .csrf().disable()
                .headers().disable();
    }
}
