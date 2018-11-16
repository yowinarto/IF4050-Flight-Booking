package com.flightbooking.ws.FlightBookingService.CancelBooking;

import java.sql.Connection;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.flightbooking.beans.Booking;
import com.flightbooking.conn.ConnectionUtils;
import com.flightbooking.utils.DBUtils;

public class AuthenticateDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Connection conn = null;
		Booking booking = null;
		try {
            conn = ConnectionUtils.getConnection();
            booking = DBUtils.findBooking(conn, (int)execution.getVariable("bookingId"));
        } catch (Exception e) {
            e.printStackTrace();
            ConnectionUtils.rollbackQuietly(conn);
        } finally {
        	ConnectionUtils.closeQuietly(conn);
        }
		if(booking == null) {
			execution.setVariable("valid", false);
		} else {
			execution.setVariable("valid", true);
			execution.setVariable("BookingDetail", booking);
		}
	}

}
