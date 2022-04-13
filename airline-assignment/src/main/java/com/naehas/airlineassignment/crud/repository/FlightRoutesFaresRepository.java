package com.naehas.airlineassignment.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naehas.airlineassignment.entity.FlightRoutesFares;

public interface FlightRoutesFaresRepository extends JpaRepository<FlightRoutesFares, Integer> {

  public List<FlightRoutesFares> findAllByOrderByIdAsc();
  public List<FlightRoutesFares> findAllByOrderByIdDesc();

}
