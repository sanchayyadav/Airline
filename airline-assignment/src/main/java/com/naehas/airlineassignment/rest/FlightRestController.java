package com.naehas.airlineassignment.rest;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naehas.airlineassignment.entity.Flight;
import com.naehas.airlineassignment.service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightRestController {

	private FlightService flightService;

	public FlightRestController(FlightService theFlightService) {
		flightService = theFlightService;

	}

	@GetMapping("/flightlist")
	public List<Flight> findAll() {
		return flightService.findAll();
	}

	@GetMapping("/flightlist/{flightId}")
	public Flight getFlight(@PathVariable int flightId) {
		Flight theFlight = flightService.findById(flightId);

		if (theFlight == null)
			throw new RuntimeException("Flight Id not find" + flightId);
		return theFlight;
	}

	@PostMapping("/flightlist")
	public Flight addFlight(@RequestBody Flight theFlight) {
		theFlight.setId(null);
		flightService.save(theFlight);
		return theFlight;

	}

	@PutMapping("/flightlist")
	public Flight updateFlight(@RequestBody Flight theFlight) {
		flightService.save(theFlight);
		return theFlight;
	}

	@DeleteMapping("/flightlist/{flightId}")
	public String deleteFlight(@PathVariable int flightId) {
		Flight tempFlight = flightService.findById(flightId);

		if (tempFlight == null) {
			throw new RuntimeException("Flight not find " + flightId);

		}

		flightService.deleteById(flightId);
		return "Deleted flight id " + tempFlight;
	}

	@GetMapping("/flightlist/airlines")
	public List<Flight> findAirline(@RequestParam String airline) {
		return flightService.findAirline(airline);
	}

}
