package bookstore.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


  /*  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/img/**", "/css/**").permitAll()
                .antMatchers("/users/register", "/users/login").permitAll()
                .antMatchers("/home", "books/details", "users/profile").hasAnyRole("USER", "ADMIN")

                /*.antMatchers("/authors/**", "/publishers/**",
                 "/categories/**","/books/**","/orders/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/home");
    }*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()/*.antMatchers("/authors/**", "/publishers/**",
                "/categories/**","/books/add","/orders/**").access("hasRole('ADMIN')")*/
                .antMatchers("/home","books/details", "users/profile", "books/details").access("hasRole('USER') or hasRole('ADMIN')")
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login?logout");

    }


}
