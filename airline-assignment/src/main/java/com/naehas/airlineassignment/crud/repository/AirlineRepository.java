package com.naehas.airlineassignment.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naehas.airlineassignment.entity.Flight;

public interface AirlineRepository extends JpaRepository<Flight, Integer> {

}
