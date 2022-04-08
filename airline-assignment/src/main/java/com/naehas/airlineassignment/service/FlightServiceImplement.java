package com.naehas.airlineassignment.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naehas.airlineassignment.crud.repository.AirlineRepository;
import com.naehas.airlineassignment.entity.Flight;

@Service
public class FlightServiceImplement implements FlightService {

	private AirlineRepository airlineRepository;

	@Autowired
	public FlightServiceImplement(AirlineRepository theAirlineRepository) {
		airlineRepository = theAirlineRepository;
	}

	@Override
	public List<Flight> findAll() {

		return airlineRepository.findAll();
	}

	@Override
	public Flight findById(int theId) {

		Optional<Flight> result = airlineRepository.findById(theId);
		Flight theFlight = null;

		if (result.isPresent()) {
			theFlight = result.get();
		} else {
			throw new RuntimeException("Do not find Flight" + theId);
		}

		return theFlight;
	}

	@Override
	public void save(Flight theFlight) {

		airlineRepository.save(theFlight);
	}

	@Override
	public void deleteById(int theId) {
		airlineRepository.deleteById(theId);
	}

}
