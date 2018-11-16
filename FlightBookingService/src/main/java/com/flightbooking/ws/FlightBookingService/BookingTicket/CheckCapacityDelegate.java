package com.flightbooking.ws.FlightBookingService.BookingTicket;

import java.text.SimpleDateFormat;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.flightbooking.beans.Flight;

public class CheckCapacityDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		boolean capacity = true;
		execution.setVariable("condition", capacity);
		if(capacity) {
			int flightId = (int)execution.getVariable("flightId");
			//SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy"); 
			Flight flight = new Flight();
			flight.setFlightId(flightId);
			flight.setPrice(10000);
			execution.setVariable("FlightDetail", flight);
		}
			
	}

}
