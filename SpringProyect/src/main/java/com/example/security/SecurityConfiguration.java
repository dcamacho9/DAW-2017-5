package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.repository.UserRepositoryAuthenticationProvider;



@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    public UserRepositoryAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	// Public pages
    	http.authorizeRequests().antMatchers("/css/**", "/js/**", "/imagenes/**").permitAll();
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/articulo").permitAll();
        http.authorizeRequests().antMatchers("/index").permitAll();
        
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/ofertas").permitAll();
        http.authorizeRequests().antMatchers("/registro").permitAll();
        http.authorizeRequests().antMatchers("/somos").permitAll();

        // Private pages (all other pages)
        http.authorizeRequests().antMatchers("/carrito").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/metodo-pago").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/miperfil").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/administrador").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/validacion-pedidos").hasAnyRole("ADMIN");


        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/loginError");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
        
        // Disable CSRF at the moment
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        // Database authentication provider
        auth.authenticationProvider(authenticationProvider);
    }

}
