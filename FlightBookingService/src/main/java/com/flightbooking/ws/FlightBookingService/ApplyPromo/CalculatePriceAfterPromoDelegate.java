package com.flightbooking.ws.FlightBookingService.ApplyPromo;

import java.sql.Connection;
import java.sql.SQLException;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.flightbooking.beans.Booking;
import com.flightbooking.beans.Promotion;
import com.flightbooking.conn.ConnectionUtils;
import com.flightbooking.utils.DBUtils;

public class CalculatePriceAfterPromoDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		Booking booking = (Booking) execution.getVariable("BookingDetail");
		Promotion promo = (Promotion) execution.getVariable("Promo");
		booking.setTotalPrice(booking.getTotalPrice()/promo.getDiscount());
		execution.setVariable("UpdatedBookingDetail", booking);
	}

}
