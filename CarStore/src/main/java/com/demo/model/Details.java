package com.demo.model;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Details {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cardetailId;
	
	    @NotNull
	   private	String body;
	    @NotNull
		private String model;
	    @NotNull
		private Integer numberOfDoors;
	    @NotNull
		private String fuelType;
	    @NotNull
		private String engine;
	    @NotNull
		private Double mileage;
	    @NotNull
		private Integer modelYear;
	    @NotNull
		private Integer productionYear;
	    @NotNull
		private String externalColor;
	    
	    @Embedded
	    private Manufacturer manufacturer;
	
	
	

}
