package com.naehas.airlineassignment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="flight_routes")
public class FlightRoutes {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="departure_location")
	private String departureLocation;
	
	@Column(name="arrival_location")
	private String arrivalLocation;
	
	@Column(name="departs_on")
	private String departsOn;
	
	@Column(name="arrives_on")
	private String arrivesOn;
	
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="flightRoutes",cascade={CascadeType.MERGE,CascadeType.DETACH,
			CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinColumn(name="fare_id")
	private FlightRoutesFares flightRoutesFare;
	
	
    
    @ManyToOne(fetch=FetchType.LAZY,cascade={CascadeType.MERGE,CascadeType.DETACH,
			CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinColumn(name="flight_id")
	private Flight flight;
    
    
    
	public FlightRoutes() {
		
	}

	public FlightRoutes(String departureLocation, String arrivalLocation, String departsOn, String arrivesOn,
			int flightId, int fareId) {
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.departsOn = departsOn;
		this.arrivesOn = arrivesOn;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public String getDepartsOn() {
		return departsOn;
	}

	public void setDepartsOn(String departsOn) {
		this.departsOn = departsOn;
	}

	public String getArrivesOn() {
		return arrivesOn;
	}

	public void setArrivesOn(String arrivesOn) {
		this.arrivesOn = arrivesOn;
	}

	

	@Override
	public String toString() {
		return "FlightRoutes [id=" + id + ", departureLocation=" + departureLocation + ", arrivalLocation="
				+ arrivalLocation + ", departsOn=" + departsOn + ", arrivesOn=" + arrivesOn +  "]";
	}
	
	
	
}
