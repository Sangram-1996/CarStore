package com.demo.model;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer {
    
	@NotNull
    private Integer	code;
	@NotNull
    private String name;

}
