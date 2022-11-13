package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Details;

public interface DetailsRepo extends JpaRepository<Details, Integer> {

}
