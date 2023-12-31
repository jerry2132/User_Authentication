package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") User user)
	{
		return "registrationForm";
		
	}
	
	@GetMapping("/user-authentication")
	public String getAuthPage(@ModelAttribute("user") User user) {
		
		return "auth";
	}
	
	@ResponseBody
	@GetMapping("/otp-validation")
	public String vaidation() {
		
		return "validation";
	}
	
	@PostMapping("/user-authentication")
	public String authenticateUser(@ModelAttribute("user") User user,Model model) {
		
		return userService.authenticateUser(user, model);
		
		
	}

	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") User user,Model model)
	{
		
		Optional<User> findUser = userRepository.findUserByEmail(user.getEmail());
		
		if(findUser.isPresent())
		{
			model.addAttribute("message", "user already present");
			return "registrationForm";
		}
		
		userService.saveUser(user);
		model.addAttribute("message", "saved Succcessfully");
		
		return "registrationForm";
	}

}
