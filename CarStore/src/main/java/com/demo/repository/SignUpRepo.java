package com.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.SignUpData;

public interface SignUpRepo extends JpaRepository<SignUpData, Integer> {

	
	public Optional<SignUpData> findByUserName(String userName);
}
