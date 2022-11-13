package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Car;

public interface CarRepo extends JpaRepository<Car, Integer> {

}
