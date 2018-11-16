package com.flightbooking.ws.FlightBookingService.BookingTicket;

import java.sql.Connection;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.flightbooking.beans.Booking;
import com.flightbooking.beans.Flight;
import com.flightbooking.conn.ConnectionUtils;
import com.flightbooking.utils.DBUtils;

public class CalculateTotalPriceDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		int numOfPassenger = (int)execution.getVariable("numOfPassenger");
		int passengerId = (int)execution.getVariable("passengerId");
		Flight flight = (Flight)execution.getVariable("FlightDetail");
		
		Booking newBooking = new Booking();
		newBooking.setID(-1);
		newBooking.setFlightID(flight.getFlightId());
		newBooking.setPassengerID(passengerId);
		newBooking.setNumOfPassenger(numOfPassenger);
		newBooking.setTotalPrice(numOfPassenger * flight.getPrice());
		execution.setVariable("BookingDetail", newBooking);
        
	}

}
