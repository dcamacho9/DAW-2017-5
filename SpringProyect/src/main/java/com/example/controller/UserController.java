package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Resource;
import com.example.entity.User;
import com.example.repository.ResourceRepository;
import com.example.repository.UserRepository;
import com.example.services.ResourceService;
import com.example.services.UserService;

public class UserController {
	
	@Autowired
	private UserService userRepository;
	
	@Autowired
	private ResourceService repository;
	
	
	
	
	@RequestMapping("/miperfil")
	public String verPerfil(Model model, HttpServletRequest request){

		User user = userRepository.findByName(request.getUserPrincipal().getName());
		model.addAttribute("user", user);
		
	

		return "miperfil";
	}
	
	
	
	
	
	

}
