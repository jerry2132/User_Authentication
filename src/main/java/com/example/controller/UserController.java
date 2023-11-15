package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	@GetMapping("/registration")
	public String getRegistrationPage()
	{
		return "registrationForm";
		
	}
	
	@PostMapping("/registration")
	public String saveUser()
	{
		return "registrationForm";
	}

}
