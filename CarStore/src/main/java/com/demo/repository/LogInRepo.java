package com.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.LogInData;

public interface LogInRepo extends JpaRepository<LogInData, Integer> {
	
	public Optional<LogInData> findByUserName(String userName);

}
