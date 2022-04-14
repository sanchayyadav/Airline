package com.naehas.airlineassignment.service;

import java.util.List;

import com.naehas.airlineassignment.entity.FlightRoutesFares;

public interface FlightRoutesFaresService  {

	public List<FlightRoutesFares> findAll();

	public FlightRoutesFares findById(int theId);

	public void save(FlightRoutesFares theFlightRoutesFares);

	public void deleteById(int theId);

	public List<FlightRoutesFares> findAllByOrderByFareDesc();

	public List<FlightRoutesFares> fareUpto(int fare);

	public List<FlightRoutesFares> fareRefundable(boolean refund);
}
