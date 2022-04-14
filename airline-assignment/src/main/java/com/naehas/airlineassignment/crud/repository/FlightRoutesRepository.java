package com.naehas.airlineassignment.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naehas.airlineassignment.entity.FlightRoutes;

public interface FlightRoutesRepository extends JpaRepository<FlightRoutes, Integer> {

	@Query("SELECT flightRoutes FROM FlightRoutes flightRoutes ORDER BY flightRoutes.departOn ")

	public List<FlightRoutes> findAllByOrderByDepartsOnAsc();
	
	@Query("SELECT flightRoutes FROM FlightRoutes flightRoutes ORDER BY flightRoutes.departOn DESC")

	public List<FlightRoutes> findAllByOrderByDepartsOnDesc();

}
