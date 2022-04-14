package com.naehas.airlineassignment.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.naehas.airlineassignment.entity.FlightRoutesFares;

public interface FlightRoutesFaresRepository extends JpaRepository<FlightRoutesFares, Integer> {

	public List<FlightRoutesFares> findAllByOrderByFareAsc();
	
	public List<FlightRoutesFares> findAllByOrderByFareDesc();
	
	@Query("SELECT flightRoutesFares FROM FlightRoutesFares flightRoutesFares WHERE flightRoutesFares.fare <= :fare")
	public List<FlightRoutesFares> fareUpto(@Param("fare") int fare);
	
	@Query("SELECT flightRoutesFares FROM FlightRoutesFares flightRoutesFares WHERE flightRoutesFares.isRefundable = :refund")
	public List<FlightRoutesFares> fareRefundable(@Param("refund") boolean refund );
}
