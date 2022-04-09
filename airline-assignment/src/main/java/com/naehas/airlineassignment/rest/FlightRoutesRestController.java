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
import com.naehas.airlineassignment.service.FlightRoutesService;

@RestController
@RequestMapping("/flightRoutes")
public class FlightRoutesRestController {

	private FlightRoutesService flightRoutesService;

	public FlightRoutesRestController(FlightRoutesService theFlightRoutesService) {
		flightRoutesService = theFlightRoutesService;
	}

	@GetMapping("/flightroutes")
	public List<FlightRoutes> findAll() {
		return flightRoutesService.findAll();
	}

	@GetMapping("/flightroutes/{flightroutesId}")
	public FlightRoutes getFlightRoutes(@PathVariable int theFlightRoutesId) {
		FlightRoutes theFlightRoutes = flightRoutesService.findById(theFlightRoutesId);

		if (theFlightRoutes == null) {
			throw new RuntimeException("Flight Id not find" + theFlightRoutesId);
		}
		return theFlightRoutes;
	}
	
	
	@PostMapping("/flightroutes")
	public FlightRoutes addFlightRoutes(@RequestBody FlightRoutes theFlightRoutes) {
		theFlightRoutes.setId(0);
		flightRoutesService.save(theFlightRoutes);
		return theFlightRoutes;
	}
	
	
	@PutMapping("/flightroutes")
	public FlightRoutes updateFlightRoutes(@RequestBody FlightRoutes theFlightRoutes) {
		flightRoutesService.save(theFlightRoutes);
		return theFlightRoutes;
	}
	
	@DeleteMapping("/flightroutes/{flightRoutesId}")
	public String deleteFlightRoutes(@PathVariable int theFlightRoutesId) {
		FlightRoutes theFlightRoutes =flightRoutesService.findById(theFlightRoutesId);
		
		if(theFlightRoutes==null) {
			throw new RuntimeException("Flight route not  able to find " + theFlightRoutesId);
		}
		flightRoutesService.deleteById(theFlightRoutesId);
		return "Deleted Flight Routes" + theFlightRoutes;
	}
}
