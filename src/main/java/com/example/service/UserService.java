package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.model.Otp;
import com.example.model.User;

@Service
public class UserService implements UserServiceContract{

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
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
