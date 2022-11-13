package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.SignUpException;
import com.demo.model.SignUpData;
import com.demo.repository.SignUpRepo;

@Service
public class SignUpServiceImpl implements SignUpService {
	
	@Autowired
	private SignUpRepo signUpRepo;

	@Override
	public SignUpData registerNewAdmin(SignUpData signUpData) throws SignUpException {
		if(signUpData ==null)
			throw new SignUpException("Null value can't be registered");
		
		SignUpData registeredData=signUpRepo.save(signUpData);
		return registeredData;
		
	}

}
