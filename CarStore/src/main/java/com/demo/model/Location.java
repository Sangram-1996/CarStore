package com.demo.model;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

	
	@NotNull
	private Double lat;
	
	@NotNull
	private Double lon;
}
