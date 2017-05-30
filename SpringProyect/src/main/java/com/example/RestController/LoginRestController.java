package com.example.RestController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.component.UserComponent;
import com.example.entity.User;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class LoginRestController {
	
	public interface UserDetail extends User.LoginInt{}
	
	@Autowired UserComponent userComponent;
	
	@JsonView(UserDetail.class)
	@RequestMapping(value="/api/login")
	public ResponseEntity<User>logIn() {
		
		if(userComponent.isLoggedUser()){
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}else{
			User loggedUser = userComponent.getLoggedUser();
			return new ResponseEntity<>(loggedUser, HttpStatus.OK);
		}
		
		
	}
	
	@RequestMapping("/api/logOut")
	public ResponseEntity<Boolean> logOut(HttpSession session){
		
		if(!userComponent.isLoggedUser()){
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}else{
			session.invalidate();
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		
	}
	
	
	
	
	

}
