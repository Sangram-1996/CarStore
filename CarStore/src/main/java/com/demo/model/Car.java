package com.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer carId;
	
	
	
	@NotNull
	private String carCondition;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Details details;
	
	@NotNull
	private Integer price;
	
	@Embedded
	private Location location;
	
	
}
