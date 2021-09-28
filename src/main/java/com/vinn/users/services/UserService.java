package com.vinn.users.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.github.javafaker.Faker;
import com.vinn.users.models.User;

@Service
public class UserService {

	@Autowired
	private Faker faker;
	
	private List<User> users = new ArrayList<>(); 
	
	@PostConstruct
	public void init() {
		for(int i=0;i<100;i++) {
		users.add(new User(faker.funnyName().name(), faker.name().username(), faker.dragonBall().character()));
		}
	}

	public List<User> getUsers() {
		return users;
	}
	
	public User getUserByUsername(String username) {
		return users.stream().filter(u->u.getUsername().equals(username)).findAny()
		.orElseThrow( ()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, 
				String.format("User %s not found", username)));
		 
	}
	
	public User createUser(User user) {
		if(users.stream().anyMatch(u->u.getUsername().equals(user.getUsername()))){
			throw new ResponseStatusException(HttpStatus.CONFLICT,String.format("User %s already exist",user.getUsername()));
		}
		users.add(user);
		return user;
		
	}
	
	public User updateUser(User user) {
		if(users.stream().anyMatch(u->u.getUsername().equals(user.getUsername()))){
			throw new ResponseStatusException(HttpStatus.CONFLICT,String.format("User %s already exist",user.getUsername()));
		}
		users.add(user);
		return user;
		
	}


	
		
}
