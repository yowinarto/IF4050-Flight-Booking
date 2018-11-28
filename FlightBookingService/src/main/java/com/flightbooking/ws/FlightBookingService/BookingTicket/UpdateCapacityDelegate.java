package com.flightbooking.ws.FlightBookingService.BookingTicket;

import java.sql.Connection;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.flightbooking.beans.Booking;
import com.flightbooking.beans.Flight;
import com.flightbooking.conn.ConnectionUtils;
import com.flightbooking.utils.DBUtils;

public class UpdateCapacityDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Connection conn = null;
		Flight flight = (Flight)execution.getVariable("FlightDetail");
		flight.setCapacity(flight.getCapacity()-(int)execution.getVariable("numOfPassenger"));
		try {
            conn = ConnectionUtils.getConnection();
            DBUtils.updateFlight(conn, flight);
        } catch (Exception e) {
            e.printStackTrace();
            ConnectionUtils.rollbackQuietly(conn);
        } finally {
        	ConnectionUtils.closeQuietly(conn);
        }
	}

}
