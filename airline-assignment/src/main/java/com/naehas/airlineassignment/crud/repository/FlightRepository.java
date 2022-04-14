package com.naehas.airlineassignment.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naehas.airlineassignment.entity.Flight;
import com.naehas.airlineassignment.entity.FlightRoutesFares;
public interface FlightRepository extends JpaRepository<Flight, Integer> {
   
	@Query("SELECT flight FROM Flight flight WHERE flight.airline LIKE %?1%")
	public List<Flight> findAirline(String airline);
	
}
