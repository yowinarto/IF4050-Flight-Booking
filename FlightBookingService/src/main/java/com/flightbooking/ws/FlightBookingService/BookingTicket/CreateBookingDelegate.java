package com.flightbooking.ws.FlightBookingService.BookingTicket;

import java.sql.Connection;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.flightbooking.beans.Booking;
import com.flightbooking.conn.ConnectionUtils;
import com.flightbooking.utils.DBUtils;

public class CreateBookingDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Connection conn = null;
		Booking newBooking = (Booking)execution.getVariable("BookingDetail");
		try {
            conn = ConnectionUtils.getConnection();
            newBooking = DBUtils.insertBooking(conn, newBooking);
        } catch (Exception e) {
            e.printStackTrace();
            ConnectionUtils.rollbackQuietly(conn);
        } finally {
        	ConnectionUtils.closeQuietly(conn);
        }
	}

}
