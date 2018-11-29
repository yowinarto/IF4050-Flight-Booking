package com.flightbooking.ws.FlightBookingService.BookingTicket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.sql.Connection;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.flightbooking.beans.Booking;
import com.flightbooking.conn.ConnectionUtils;
import com.flightbooking.utils.DBUtils;

public class ConfirmPaymentDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Booking booking = (Booking) execution.getVariable("BookingDetail");
		String urlToRead = "http://localhost:8082/?paymentMethod=bank&amount=" + booking.getTotalPrice() + "&businessKey=" + execution.getBusinessKey() + "&service=payment";
		execution.setVariable("payment", true);
		StringBuilder result = new StringBuilder();
	    URL url = new URL(urlToRead);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    String line;
	    while ((line = rd.readLine()) != null) {
	       result.append(line);
	    }
	    rd.close();
	}

}
