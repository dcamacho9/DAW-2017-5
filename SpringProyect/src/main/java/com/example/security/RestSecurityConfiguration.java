package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.repository.UserRepositoryAuthenticationProvider;

@Configuration
@Order(1)
public class RestSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired 
	public UserRepositoryAuthenticationProvider userRepoAuthProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.antMatcher("/api/**");
		
		 
		// URLS que necesitan autenticación
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,
				"/api/resources/all",
				"/api/resources/{id}",
				"/api/ofertas/all",
				"/api/ofertas/{id}",
				"/api/ofertas/{code}",
				"/api/ofertasDescuento/all",
				"/api/ofertasDescuento/{code}").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET,
				"/api/purcharseOrder/{id}",
				"/api/purcharseOrder/{tittle}").hasAnyRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/users/all").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.POST,"api/users/").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST,
				"/api/resources/",
				"/api/ofertas/",
				"/api/ofertasDescuento/").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/**/**").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/users/{id}").hasAnyRole("USER","ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT,
				"/api/resources/{id}",
				"/api/ofertas/{id}",
				"/api/ofertasDescuento/{code}").hasAnyRole("ADMIN");
				
				
				
				
		
		
				
				
				
				
				
				
		
		
		// http
		
		http.httpBasic();

		http.logout().logoutSuccessHandler((rq,rs,a)->{ });
		
		http.csrf().disable();
		
	}
		
		
		
		@Override
		protected void configure( AuthenticationManagerBuilder auth) throws Exception{
			auth.authenticationProvider(userRepoAuthProvider);
		}
		
		
		
		
	
		
	

}  
