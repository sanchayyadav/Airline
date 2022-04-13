package com.naehas.airlineassignment.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="flights")
public class Flight {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	
	@Column(name="airline")
	private String airline;
	
	
	@Column(name="flight_no")
	private String flightNo;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL) 
	private List<FlightRoutes> flightRoutes;
	
	
	public Flight() {
		
	}


	public Flight(String airline, String flightNo) {
		this.airline = airline;
		this.flightNo = flightNo;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAirline() {
		return airline;
	}


	public void setAirline(String airline) {
		this.airline = airline;
	}


	public String getFlightNo() {
		return flightNo;
	}


	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}


	@Override
	public String toString() {
		return "Flight [id=" + id + ", airline=" + airline + ", flightNo=" + flightNo + "]";
	}
	
	
	
}
