package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Otp;

public interface OtpRepository extends JpaRepository<Otp , Long>{
	
	Optional<Otp> findOtpByEmail(String email);

}
