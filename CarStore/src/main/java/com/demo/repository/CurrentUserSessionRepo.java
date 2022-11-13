package com.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.CurrentUserSession;

public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession, Integer> {

	
	
	    Optional<CurrentUserSession> findByUsername(String username);
	    
	    Optional<CurrentUserSession> findByUuid(String uuid);
	     
}
