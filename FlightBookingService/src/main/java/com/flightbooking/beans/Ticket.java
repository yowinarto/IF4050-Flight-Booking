package com.flightbooking.beans;
import java.io.Serializable;
public class Ticket implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ticket_code;
	private int passenger_id;
	private int booking_id;
	public String getTicketCode() {
		return ticket_code;
	}
	public void setTicketCode(String ticket_code) {
		this.ticket_code = ticket_code;
	}
	public int getBookingID() {
		return booking_id;
	}
	public void setBookingID(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getPassengerID() {
		return passenger_id;
	}
	public void setPassengerID(int passenger_id) {
		this.passenger_id = passenger_id;
	}
	
	@Override
	public String toString() {
		return ticket_code + "::" + passenger_id + "::" + booking_id;
	}
}
