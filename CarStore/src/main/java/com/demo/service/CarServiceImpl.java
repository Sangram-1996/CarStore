package com.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.CarException;
import com.demo.exception.LogInException;
import com.demo.model.Car;
import com.demo.model.CurrentUserSession;
import com.demo.repository.CarRepo;
import com.demo.repository.CurrentUserSessionRepo;
@Service
public class CarServiceImpl implements CarsService {
	@Autowired
	private CarRepo carRepo;
	
	@Autowired
	private CurrentUserSessionRepo currentUserSessionRepo;

	@Override
	public Car addNewCar(Car car,String key) throws CarException,LogInException {
		
		Optional<CurrentUserSession> checkUserSession=currentUserSessionRepo.findByUuid(key);
		
		if(checkUserSession.isEmpty())
			throw new LogInException("Kindly login to add new car to database");
		
		Car savedCar=carRepo.save(car);
		return savedCar;
		
	}

	@Override
	public Car getCarbyId(Integer carId, String key) throws CarException, LogInException {
		
Optional<CurrentUserSession> checkUserSession=currentUserSessionRepo.findByUuid(key);
		
		if(checkUserSession.isEmpty())
			throw new LogInException("Kindly login to search car by id");
		
		Optional<Car> carById=carRepo.findById(carId);
		
		if(carById.isEmpty()) 
			throw new CarException("No car found with given id");
		
		return carById.get();
	}

	@Override
	public Car updateCarPrice(Integer carid,Integer price, String key) throws CarException, LogInException {
Optional<CurrentUserSession> checkUserSession=currentUserSessionRepo.findByUuid(key);
		
		if(checkUserSession.isEmpty())
			throw new LogInException("Kindly login to update a car properties");
		
		Car findCar=carRepo.findById(carid).get();
		
		if(findCar==null) 
			throw new CarException("No car found with the given id");
			
		findCar.setPrice(price);
		
		Car updatedCar=carRepo.save(findCar);
		
		return updatedCar;
		
		
		
	}

	@Override
	public Car deleteCarById(Integer carid, String key) throws CarException, LogInException {
Optional<CurrentUserSession> checkUserSession=currentUserSessionRepo.findByUuid(key);
		
		if(checkUserSession.isEmpty())
			throw new LogInException("Kindly login to delete a car from database");
		
		Optional<Car> findCar= carRepo.findById(carid);
		
		if(findCar.isEmpty())
			throw new CarException("No car found with this given carid");
		
		carRepo.delete(findCar.get());
		
		return findCar.get();
		
		
	}

}
