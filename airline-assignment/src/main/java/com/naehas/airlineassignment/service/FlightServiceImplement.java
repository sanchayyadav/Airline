package com.naehas.airlineassignment.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naehas.airlineassignment.crud.repository.FlightRepository;
import com.naehas.airlineassignment.entity.Flight;

@Service
public class FlightServiceImplement implements FlightService {

	private FlightRepository flightRepository;

	@Autowired
	public FlightServiceImplement(FlightRepository theFlightRepository) {
		flightRepository = theFlightRepository;
	}

	@Override
	public List<Flight> findAll() {

		return flightRepository.findAll();
	}

	@Override
	public Flight findById(int theId) {

		Optional<Flight> result = flightRepository.findById(theId);
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

		flightRepository.save(theFlight);
	}

	@Override
	public void deleteById(int theId) {
		flightRepository.deleteById(theId);
	}

}
