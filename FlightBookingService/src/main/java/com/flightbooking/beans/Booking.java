package com.flightbooking.beans;

import java.io.Serializable;

public class Booking implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int passenger_id;
	private int num_of_passenger;
	private float total_price;
	private int flight_id;
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public int getPassengerID() {
		return passenger_id;
	}
	public void setPassengerID(int passenger_id) {
		this.passenger_id = passenger_id;
	}
	public int getNumOfPassenger() {
		return num_of_passenger;
	}
	public void setNumOfPassenger(int num_of_passenger) {
		this.num_of_passenger = num_of_passenger;
	}
	public float getTotalPrice() {
		return total_price;
	}
	public void setTotalPrice(float total_price) {
		this.total_price = total_price;
	}
	public int getFlightID() {
		return flight_id;
	}
	public void setFlightID(int flight_id) {
		this.flight_id = flight_id;
	}
	
	@Override
	public String toString() {
		return id + "::" + passenger_id + "::" + num_of_passenger + "::" + total_price + "::" + flight_id;
	}
}
