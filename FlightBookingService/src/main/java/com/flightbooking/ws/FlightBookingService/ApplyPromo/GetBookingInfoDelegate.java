package com.flightbooking.ws.FlightBookingService.ApplyPromo;

import java.sql.Connection;
import java.sql.SQLException;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.flightbooking.beans.Booking;
import com.flightbooking.conn.ConnectionUtils;
import com.flightbooking.utils.DBUtils;

public class GetBookingInfoDelegate implements JavaDelegate {

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
		execution.setVariable("BookingDetail", booking);
	}

}
