package com.demo.service;

import com.demo.exception.CarException;
import com.demo.exception.LogInException;
import com.demo.model.Car;

public interface CarsService {

	
	public Car addNewCar(Car car,String key)throws CarException, LogInException;

	public Car getCarbyId(Integer carId, String key)throws CarException, LogInException;
	
	public Car updateCarPrice(Integer carid, Integer price, String key)throws CarException, LogInException;
	
	public Car deleteCarById(Integer carid,String key)throws CarException, LogInException;
	
}
