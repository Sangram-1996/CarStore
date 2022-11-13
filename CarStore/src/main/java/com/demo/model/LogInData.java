package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogInData {

	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loginId;
	@NotNull
	private String userName;
	@NotNull
	private String password;
}
