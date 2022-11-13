package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exception.CarException;
import com.demo.exception.LogInException;
import com.demo.exception.SignUpException;
import com.demo.model.Car;
import com.demo.model.LogInData;
import com.demo.model.SignUpData;
import com.demo.service.CarsService;
import com.demo.service.LogInService;
import com.demo.service.SignUpService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AdminController {
	
	@Autowired
	private SignUpService signUpService;
	
	@Autowired
	private LogInService logInService;
	
	@Autowired
	private CarsService carService;
	
	@PostMapping("/register")
	public ResponseEntity<SignUpData> signupRegisterHandler(@RequestBody SignUpData signUpData) throws SignUpException{
		
		SignUpData registeredData=signUpService.registerNewAdmin(signUpData);
		
		return new ResponseEntity<SignUpData>(registeredData, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> logInUserHandler(@RequestBody LogInData logInData) throws LogInException{
		
		String message= logInService.logInAccount(logInData);
		
		return new ResponseEntity<String>(message,HttpStatus.CREATED);	
	}
	
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> logoutUserHandler(@RequestParam String key) throws LogInException{
		
		String message=logInService.logoutAccount(key);
		
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@PostMapping("/cars")
	public ResponseEntity<Car> addNewCarHandler(@RequestBody Car car,@RequestParam String key) throws CarException, LogInException {
		
		Car addNewCarData= carService.addNewCar(car,key);
		
		return new ResponseEntity<Car>(addNewCarData,HttpStatus.CREATED);	
	}
	
	
	@GetMapping("/cars/{id}")
	public ResponseEntity<Car> carByIdHandler(@PathVariable Integer id,@RequestParam String key) throws LogInException, CarException{
		
		Car carById=carService.getCarbyId(id, key);
		
		return new ResponseEntity<Car>(carById, HttpStatus.OK);
	}
	
	
	@PutMapping("/cars/{id}/{price}")
	public ResponseEntity<Car> updateCarByIdHandler(@PathVariable Integer id, @PathVariable Integer price,@RequestParam String key) throws LogInException, CarException{
		
		Car updatedCar=carService.updateCarPrice(id, price, key);
		
		return new ResponseEntity<Car>(updatedCar, HttpStatus.OK);
	}
	
	@DeleteMapping("/cars/{id}")
	public ResponseEntity<Car> deleteCarByIdHandler(@PathVariable Integer id,@RequestParam String key) throws LogInException, CarException{
		
		Car deletedCar=carService.deleteCarById(id, key);
		
		return new ResponseEntity<Car>(deletedCar, HttpStatus.OK);
	}
	
	

}
