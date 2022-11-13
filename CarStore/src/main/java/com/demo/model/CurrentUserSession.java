package com.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CurrentUserSession {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	
	private String username;
	
	private String uuid;
	
	private LocalDateTime localDateTime;

	public CurrentUserSession(String username, String uuid, LocalDateTime localDateTime) {
		super();
		this.username = username;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}

}
