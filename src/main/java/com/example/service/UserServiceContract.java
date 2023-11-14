package com.example.service;

import org.springframework.ui.Model;

import com.example.model.Otp;
import com.example.model.User;

public interface UserServiceContract {
	
	public void saveUser(User user);
	public String  authenticateUser(User user,Model model);
	public boolean checkOtpValidity(Otp otp);

}
