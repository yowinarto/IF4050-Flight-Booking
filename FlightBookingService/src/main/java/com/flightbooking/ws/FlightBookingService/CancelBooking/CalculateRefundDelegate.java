package com.flightbooking.ws.FlightBookingService.CancelBooking;

import java.sql.Connection;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.flightbooking.beans.Booking;
import com.flightbooking.conn.ConnectionUtils;
import com.flightbooking.utils.DBUtils;

public class CalculateRefundDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Booking booking = (Booking) execution.getVariable("BookingDetail");
		execution.setVariable("Refund", booking.getTotalPrice());
	}

}
