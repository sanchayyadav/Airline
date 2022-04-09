package com.naehas.airlineassignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="flight_fare")
public class FlightRoutesFares {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="classs")
	private String classs;
	
	@Column(name="fare")
	private int fare;
	
	@Column(name="is_refundable")
	private boolean isRefundable;
	
	
	public FlightRoutesFares() {
		
	}


	public FlightRoutesFares(String classs, int fare, boolean isRefundable) {
		this.classs = classs;
		this.fare = fare;
		this.isRefundable = isRefundable;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getClasss() {
		return classs;
	}


	public void setClasss(String classs) {
		this.classs = classs;
	}


	public int getFare() {
		return fare;
	}


	public void setFare(int fare) {
		this.fare = fare;
	}


	public boolean isRefundable() {
		return isRefundable;
	}


	public void setRefundable(boolean isRefundable) {
		this.isRefundable = isRefundable;
	}


	@Override
	public String toString() {
		return "FlightRoutesFares [id=" + id + ", classs=" + classs + ", fare=" + fare + ", isRefundable="
				+ isRefundable + "]";
	}
	
	
}
