package com.demo.service;

import com.demo.exception.LogInException;
import com.demo.model.LogInData;

public interface LogInService {
	
	
	public String logInAccount(LogInData logInData)throws LogInException;
	
	public String logoutAccount(String key)throws LogInException;
	
	

}
