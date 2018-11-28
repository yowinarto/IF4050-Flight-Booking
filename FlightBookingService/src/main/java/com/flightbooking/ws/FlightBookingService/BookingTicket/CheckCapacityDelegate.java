package com.flightbooking.ws.FlightBookingService.BookingTicket;

import java.sql.Connection;
import java.text.SimpleDateFormat;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.flightbooking.beans.Booking;
import com.flightbooking.beans.Flight;
import com.flightbooking.conn.ConnectionUtils;
import com.flightbooking.utils.DBUtils;

public class CheckCapacityDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		boolean capacity = true;
		Connection conn = null;
		Flight flight = null;
		try {
            conn = ConnectionUtils.getConnection();
            flight = DBUtils.findFlight(conn, (int)execution.getVariable("flightId"));
        } catch (Exception e) {
            e.printStackTrace();
            ConnectionUtils.rollbackQuietly(conn);
        } finally {
        	ConnectionUtils.closeQuietly(conn);
        }
		if(flight == null) {
			capacity = false;
		} else {
			if (flight.getCapacity()-(int)execution.getVariable("numOfPassenger") >= 0) {
				execution.setVariable("FlightDetail", flight);
			} else {
				capacity = false;
			}
		}
		execution.setVariable("condition", capacity);
	}

}
