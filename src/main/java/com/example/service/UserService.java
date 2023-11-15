package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.model.Otp;
import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserService implements UserServiceContract{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		
	}

	@Override
	public String authenticateUser(User user, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkOtpValidity(Otp otp) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
