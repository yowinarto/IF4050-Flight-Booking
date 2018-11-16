package com.flightbooking.beans;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Flight implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int flightId;
	private Date dateFlight;
	private String flightClass;
	private String origin;
	private String destination;
	private Time timeFlight;
	private float price;
	public Date getDateFlight() {
		return dateFlight;
	}
	public void setDateFlight(Date dateFlight) {
		this.dateFlight = dateFlight;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Time getTimeFlight() {
		return timeFlight;
	}
	public void setTimeFlight(Time timeFlight) {
		this.timeFlight = timeFlight;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return flightId + "::" + dateFlight + "::" + flightClass + "::" + origin + "::" + destination + "::" + timeFlight + "::" + price;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
}
