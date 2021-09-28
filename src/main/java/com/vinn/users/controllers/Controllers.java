package com.vinn.users.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Stereotype
@RequestMapping("/hello")
public class Controllers {
	
	@GetMapping
	public String helloWorld() {
		return "Hello world!!!";
	}
	

}
