package com.naehas.airlineassignment.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naehas.airlineassignment.crud.repository.FlightRoutesRepository;
import com.naehas.airlineassignment.entity.FlightRoutes;


@Service
public class FlightRoutesServiceImplements implements FlightRoutesService {

	private FlightRoutesRepository flightRoutesRepository;

	@Autowired
	public FlightRoutesServiceImplements(FlightRoutesRepository theFlightRoutesRepository) {
		flightRoutesRepository = theFlightRoutesRepository;
	}

	@Override
	public List<FlightRoutes> findAll() {

		return flightRoutesRepository.findAll();
	}

	@Override
	public FlightRoutes findById(int theId) {

		Optional<FlightRoutes> result = flightRoutesRepository.findById(theId);
		FlightRoutes theFlightRoutes = null;

		if (result.isPresent()) {
			theFlightRoutes = result.get();
		} else {
			throw new RuntimeException("Do not find Flight" + theId);
		}

		return theFlightRoutes;
	}

	@Override
	public void save(FlightRoutes theFlightRoutes) {

		flightRoutesRepository.save(theFlightRoutes);
	}

	@Override
	public void deleteById(int theId) {
		flightRoutesRepository.deleteById(theId);
	}

	@Override
	public List<FlightRoutes> findAllByOrderByDepartsOnDesc() {
		
		return flightRoutesRepository.findAllByOrderByDepartsOnDesc();
	}
	@Override
	public List<FlightRoutes> searchFlightRoutes(String departureLocation, String arrivalLocation,String departsOn) {
		if(departureLocation == null) {
			throw new RuntimeException("departureLocation missing");
		}
		else if(arrivalLocation == null) {
			throw new RuntimeException("arrivalLocation missing");
		}
		else if(departsOn == null) {
			throw new RuntimeException("Departing time is missing");
		}
		return flightRoutesRepository.search(departureLocation, arrivalLocation, departsOn);
	}
}
