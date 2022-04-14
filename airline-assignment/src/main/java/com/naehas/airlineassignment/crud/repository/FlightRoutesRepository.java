package com.naehas.airlineassignment.crud.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.naehas.airlineassignment.entity.FlightRoutes;

public interface FlightRoutesRepository extends JpaRepository<FlightRoutes, Integer> {


	@Query("SELECT flightRoutes FROM FlightRoutes flightRoutes WHERE flightRoutes.departureLocation = :departureLocation"
            + " OR flightRoutes.arrivalLocation = :arrivalLocation"
            + " OR flightRoutes.departsOn = :departsOn" )
	public List<FlightRoutes> search(@Param("departureLocation") String departureLocation,
									@Param("arrivalLocation") String arrivalLocation,
									@RequestParam("departsOn") String departsOn);
	
//	@Query("SELECT flightRoutes FROM FlightRoutes flightRoutes ORDER BY flightRoutes.departsOn ")

	public List<FlightRoutes> findAllByOrderByDepartsOnAsc();
	
//	@Query("SELECT flightRoutes FROM FlightRoutes flightRoutes ORDER BY flightRoutes.departsOn DESC")


	public List<FlightRoutes> findAllByOrderByDepartsOnDesc();

}
