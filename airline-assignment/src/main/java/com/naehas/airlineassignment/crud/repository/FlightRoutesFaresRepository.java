package com.naehas.airlineassignment.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naehas.airlineassignment.entity.FlightRoutesFares;

public interface FlightRoutesFaresRepository extends JpaRepository<FlightRoutesFares, Integer> {

	@Query("SELECT flightRoutesFares FROM FlightRoutesFares flightRoutesFares ORDER BY flightRoutesFares.fare ")
	public List<FlightRoutesFares> findAllByOrderByFareAsc();//doubt
	
	@Query("SELECT flightRoutesFares FROM FlightRoutesFares flightRoutesFares ORDER BY flightRoutesFares.fare DESC")
	public List<FlightRoutesFares> findAllByOrderByFareDesc();
}
