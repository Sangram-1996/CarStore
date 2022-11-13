package com.demo.service;

import com.demo.exception.SignUpException;
import com.demo.model.SignUpData;

public interface SignUpService {
	
	public SignUpData registerNewAdmin(SignUpData signUpData)throws SignUpException;

}
