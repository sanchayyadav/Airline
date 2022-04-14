package com.naehas.airlineassignment.service;

import java.time.LocalDateTime;
import java.util.List;

import com.naehas.airlineassignment.entity.Flight;
import com.naehas.airlineassignment.entity.FlightRoutes;

public interface FlightRoutesService {

	public List<FlightRoutes> findAll();

	public FlightRoutes findById(int theId);

	public void save(FlightRoutes theFlightRoutes);

	public void deleteById(int theId);

	public List<FlightRoutes> findAllByOrderByDepartsOnDesc();

	public List<FlightRoutes> searchFlightRoutes(String departureLocation, String arrivalLocation, String departsOn);
}
