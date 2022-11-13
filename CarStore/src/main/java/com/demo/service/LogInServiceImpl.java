package com.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.LogInException;
import com.demo.model.CurrentUserSession;
import com.demo.model.LogInData;
import com.demo.model.SignUpData;
import com.demo.repository.CurrentUserSessionRepo;
import com.demo.repository.LogInRepo;
import com.demo.repository.SignUpRepo;

@Service
public class LogInServiceImpl implements LogInService {
	
	@Autowired
	private SignUpRepo signUpRepo;
	
	@Autowired
	private CurrentUserSessionRepo currentUserSessionRepo;
	
	
	@Autowired
	private LogInRepo logInRepo;
	
	
	public static String getRandomNumberString() {
		   
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	  
	    return String.format("%06d", number);
	}
	
	
	
	

	@Override
	public String logInAccount(LogInData logInData) throws LogInException {
		
		
		Optional<SignUpData> signUpOpt= signUpRepo.findByUserName(logInData.getUserName());
		
		if(signUpOpt.isEmpty())
			throw new LogInException("Invalid Login Username");
		
		SignUpData newSignUp = signUpOpt.get();
		
		String newSignUpusername = newSignUp.getUserName();
		
		
		Optional<CurrentUserSession> currentUserOpt=currentUserSessionRepo.findByUsername(newSignUpusername);
		
		if(currentUserOpt.isPresent())
			throw new LogInException("User alredy logged in with this username");
		
		if(newSignUp.getUserName().equals(logInData.getUserName()) &&  newSignUp.getPassword().equals(logInData.getPassword())) {
			String key=this.getRandomNumberString();
			
			CurrentUserSession storenewLoginData=new CurrentUserSession(newSignUp.getUserName(),key,LocalDateTime.now());
			currentUserSessionRepo.save(storenewLoginData);
			
			logInRepo.save(logInData);
			
			return storenewLoginData.toString();
			
		}
		
		throw new LogInException("Wrong credential");	
	}
	

	@Override
	public String logoutAccount(String key) throws LogInException {
		Optional<CurrentUserSession> currentUserOptional = currentUserSessionRepo.findByUuid(key);
		if(currentUserOptional.isEmpty())
		{
			throw new LogInException("User has not logged in...");
		}
		
		currentUserSessionRepo.delete(currentUserOptional.get());
		
		Optional<LogInData> loginData = logInRepo.findByUserName(currentUserOptional.get().getUsername());

		logInRepo.delete(loginData.get());
		
		
		return "Logged Out......";
	}
}
