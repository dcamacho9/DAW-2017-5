package com.example.component;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.example.entity.User;

@Component
@Scope(value= WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserComponent {
	//Usamos esta clase para manejar la informacion del usuario mientras hace login en la aplicacion

	private User user;
	
	public User getLoggedUser(){
		return user;
	}
	public void setLoggedUser(User user){
		this.user= user;
	}
	public boolean isLoggedUser(){
		return this.user !=null;
	}
	
}
