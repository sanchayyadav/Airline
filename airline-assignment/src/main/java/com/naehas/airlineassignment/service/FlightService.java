package com.naehas.airlineassignment.service;

import java.util.List;

import com.naehas.airlineassignment.entity.Flight;

public interface FlightService {

	public List<Flight> findAll();

	public Flight findById(int theId);

	public void save(Flight theFlight);

	public void deleteById(int theId);

	public List<Flight> findAirline(String airline);
	

}
