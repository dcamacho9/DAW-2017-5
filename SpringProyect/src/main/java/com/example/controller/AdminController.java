package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repository.ResourceRepository;
import com.example.repository.UserRepository;

@Controller
public class AdminController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping("/admin/")
	public String home(Model model){
		return "admin";
	}
	@RequestMapping ("/admin/users")
	public String users (Model model){
		model.addAttribute("users",userRepository.findAll());
		return"admin/perfil_ajeno";
		
		
	}
	@RequestMapping ("/admin/ofertas")
	public String ofertas(Model model){
		return "admin/ofertas";
	}
	@RequestMapping ("admin/miperfil")
	public String miperfil(Model model){
		return "admin/miperfil";
		
	
	}

}
