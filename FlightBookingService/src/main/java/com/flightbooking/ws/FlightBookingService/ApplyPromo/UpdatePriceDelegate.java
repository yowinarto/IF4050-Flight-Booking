package com.flightbooking.ws.FlightBookingService.ApplyPromo;

import java.sql.Connection;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.flightbooking.beans.Booking;
import com.flightbooking.conn.ConnectionUtils;
import com.flightbooking.utils.DBUtils;

public class UpdatePriceDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Connection conn = null;
		Booking booking = (Booking)execution.getVariable("UpdatedBookingDetail");
		try {
            conn = ConnectionUtils.getConnection();
            DBUtils.updateBooking(conn, booking);
        } catch (Exception e) {
            e.printStackTrace();
            ConnectionUtils.rollbackQuietly(conn);
        } finally {
        	ConnectionUtils.closeQuietly(conn);
        }
	}

}
