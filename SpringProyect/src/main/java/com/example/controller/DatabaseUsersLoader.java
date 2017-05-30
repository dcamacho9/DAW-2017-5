package com.example.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.Resource;
import com.example.entity.User;
import com.example.repository.UserRepository;

@Component
public class DatabaseUsersLoader {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void initDatabase() {
    	
    	userRepository.save(new User("user1", "Pedro Martínez Pérez","pmartinez@gmail.com","España","Calle Santillana 2 3ºB, Móstoles","6546678876","pass",23340,"ROLE_USER"));
		userRepository.save(new User("admin", "Marco Polo Martínez","marcop@gmail.com","España","Calle Colón 2 4ºA, Majadahonda","6432378876","pass",23340, "ROLE_USER", "ROLE_ADMIN"));
		
		User user2 = new User("user2", "Miguel Sánchez Pérez","pmartinez@gmail.com","España","Calle Nájera 5 1ºC, Arroyomolinos","6455668876","pass",23340,"ROLE_USER");
		userRepository.save(user2);
    }

}
