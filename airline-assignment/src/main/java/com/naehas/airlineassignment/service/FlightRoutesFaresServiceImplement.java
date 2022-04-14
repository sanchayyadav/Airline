package com.naehas.airlineassignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naehas.airlineassignment.crud.repository.FlightRoutesFaresRepository;
import com.naehas.airlineassignment.entity.FlightRoutesFares;


@Service
public class FlightRoutesFaresServiceImplement implements FlightRoutesFaresService {

	private FlightRoutesFaresRepository flightRoutesFaresRepository;

	@Autowired
	public FlightRoutesFaresServiceImplement(FlightRoutesFaresRepository theFlightRoutesFaresRepository) {
		flightRoutesFaresRepository = theFlightRoutesFaresRepository;
	}

	@Override
	public List<FlightRoutesFares> findAll() {

		return flightRoutesFaresRepository.findAll();
	}

	@Override
	public FlightRoutesFares findById(int theId) {

		Optional<FlightRoutesFares> result = flightRoutesFaresRepository.findById(theId);
		FlightRoutesFares theFlightRoutesFares = null;

		if (result.isPresent()) {
			theFlightRoutesFares = result.get();
		} else {
			throw new RuntimeException("Do not find Flight" + theId);
		}

		return theFlightRoutesFares;
	}

	@Override
	public void save(FlightRoutesFares theFlightRoutes) {

		flightRoutesFaresRepository.save(theFlightRoutes);
	}

	@Override
	public void deleteById(int theId) {
		flightRoutesFaresRepository.deleteById(theId);
	}
	
	@Override
	public List<FlightRoutesFares> findAllByOrderByFareDesc(){
		return flightRoutesFaresRepository.findAllByOrderByFareDesc();
	} 

	@Override
	public List<FlightRoutesFares> fareUpto(int fare) {
		
		return flightRoutesFaresRepository.fareUpto(fare);
	}

	@Override
	public List<FlightRoutesFares> fareRefundable(boolean refund) {
		
		return flightRoutesFaresRepository.fareRefundable(refund);
	}

}
