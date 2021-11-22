package com.vinn.users;

import java.util.Iterator;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;
import com.vinn.users.entities.Role;
import com.vinn.users.entities.User;
import com.vinn.users.entities.UserInRole;
import com.vinn.users.repositories.RoleRepository;
import com.vinn.users.repositories.UserInRoleRepository;
import com.vinn.users.repositories.UserRepository;

@SpringBootApplication
public class UsersAppApplication implements ApplicationRunner {

	@Autowired
	private Faker faker;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserInRoleRepository userInRoleRepository;
		
	public static void main(String[] args) {
		SpringApplication.run(UsersAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Role roles[]= {new Role("ADMIN"), new Role("SUPPORT"), new Role("USER")}; 
		
		for (Role role: roles) {
			
			roleRepository.save(role);
		}
		
		for(int i = 0; i < 100; i++) {
			User user = new User();
			user.setUsername(faker.name().username());
			user.setPassword(faker.dragonBall().character());
			User created = repository.save(user);
			
			UserInRole userInRole =  new UserInRole(created, roles[new Random().nextInt(3)]);
			userInRoleRepository.save(userInRole);
		}
		
	}

}
