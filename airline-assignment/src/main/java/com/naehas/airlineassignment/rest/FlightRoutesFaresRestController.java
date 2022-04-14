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

import com.naehas.airlineassignment.entity.FlightRoutes;
import com.naehas.airlineassignment.entity.FlightRoutesFares;
import com.naehas.airlineassignment.service.FlightRoutesFaresService;

@RestController
@RequestMapping("/flightRoutesFare")
public class FlightRoutesFaresRestController {

	private FlightRoutesFaresService flightRoutesFaresService;

	public FlightRoutesFaresRestController(FlightRoutesFaresService theFlightRoutesFaresService) {
		flightRoutesFaresService = theFlightRoutesFaresService;
	}

	@GetMapping("/flightroutesfares")
	public List<FlightRoutesFares> findAll() {
		return flightRoutesFaresService.findAll();
	}

	@GetMapping("/flightroutesfares/{flightroutesfaresId}")
	public FlightRoutesFares getFlightRoutesFares(@PathVariable int flightroutesfaresId) {
		FlightRoutesFares theFlightRoutes = flightRoutesFaresService.findById(flightroutesfaresId);

		if (theFlightRoutes == null) {
			throw new RuntimeException("Flight Id not find" + flightroutesfaresId);
		}
		return theFlightRoutes;
	}

	@PostMapping("/flightroutesfares")
	public FlightRoutesFares addFlightRoutesFares(@RequestBody FlightRoutesFares theFlightRoutesFares) {
		theFlightRoutesFares.setId(0);
		flightRoutesFaresService.save(theFlightRoutesFares);
		return theFlightRoutesFares;
	}

	@PutMapping("/flightroutesfares")
	public FlightRoutesFares updateFlightRoutesFares(@RequestBody FlightRoutesFares theFlightRoutesFares) {
		flightRoutesFaresService.save(theFlightRoutesFares);
		return theFlightRoutesFares;
	}

	@DeleteMapping("/flightroutesfares/{flightRoutesFaresId}")
	public String deleteFlightRoutesFares(@PathVariable int flightRoutesFaresId) {
		FlightRoutesFares theFlightRoutesFares = flightRoutesFaresService.findById(flightRoutesFaresId);

		if (theFlightRoutesFares == null) {
			throw new RuntimeException("Flight route not  able to find " + flightRoutesFaresId);
		}
		flightRoutesFaresService.deleteById(flightRoutesFaresId);
		return "Deleted Flight Routes Fares" + theFlightRoutesFares;
	}
}
