package com.flightbooking.ws.FlightBookingService.CancelBooking;

import java.sql.Connection;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.flightbooking.beans.Booking;
import com.flightbooking.conn.ConnectionUtils;
import com.flightbooking.utils.DBUtils;

public class UpdateFlightDataDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Connection conn = null;
		Booking booking = (Booking) execution.getVariable("BookingDetail");
        try {
            conn = ConnectionUtils.getConnection();
            DBUtils.deleteBooking(conn, booking.getID());
        } catch (Exception e) {
            e.printStackTrace();
            ConnectionUtils.rollbackQuietly(conn);
        } finally {
        	ConnectionUtils.closeQuietly(conn);
        }
	}

}
