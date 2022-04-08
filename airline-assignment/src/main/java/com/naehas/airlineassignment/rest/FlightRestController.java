package com.naehas.airlineassignment.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naehas.airlineassignment.entity.Flight;
import com.naehas.airlineassignment.service.FlightService;

@RestController
@RequestMapping("/flight")
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
		theFlight.setId(0);
		flightService.save(theFlight);
		return theFlight;

	}

	@PutMapping("/flightlist")
	public Flight updateFlight(@RequestBody Flight theFlight) {
		flightService.save(theFlight);
		return theFlight;
	}

	@DeleteMapping("/flightlist/{flightId}")
	public String deleteFlight(@PathVariable int theFlight) {
		Flight tempFlight = flightService.findById(theFlight);

		if (tempFlight == null) {
			throw new RuntimeException("Flight not find " + theFlight);

		}

		flightService.deleteById(theFlight);
		return "Deleted flight id " + tempFlight;
	}
}
