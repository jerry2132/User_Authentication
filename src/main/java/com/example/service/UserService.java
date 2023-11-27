package com.example.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.model.Otp;
import com.example.model.User;
import com.example.repository.OtpRepository;
import com.example.repository.UserRepository;

@Service
public class UserService implements UserServiceContract{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	private OtpRepository otpRepository;

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		
	}

	@Override
	public String authenticateUser(User user, Model model) {
		// TODO Auto-generated method stub
		
		Optional<User> findUser = userRepository.findUserByEmail(user.getEmail());
		
		if(findUser.isPresent()) {
			
			User checkedUser = findUser.get();
			if(passwordEncoder.matches(user.getPassword(), checkedUser.getPassword())){
				
				return "redirect:/otp-validation";
				
			} else {
				model.addAttribute("message", "bad ceredentials");
				return "auth";
			}
			
		}
		
		else {
			
			model.addAttribute("message", "bad ceredentials");
			return "auth";
			
		}
		
	}

	@Override
	public boolean checkOtpValidity(Otp otp) {
		// TODO Auto-generated method stub
		return false;
	}

	public void renewOtp(User user) {
		
		Optional<Otp> findUser = otpRepository.findOtpByEmail(user.getEmail());
		
		
	}
	
}
