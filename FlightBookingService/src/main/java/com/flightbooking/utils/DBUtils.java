package com.flightbooking.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flightbooking.beans.*;

public class DBUtils {
	public static Promotion findPromo(Connection conn, String promoCode) throws SQLException {
		 
        String sql = "Select a.promo_code, a.available_from, a.available_until, a.discount from promotion a "//
                + " where a.promo_code = ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, promoCode);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
        	Date availableFrom = rs.getDate("available_from");
        	Date availableUntil = rs.getDate("available_until");
        	float discount = rs.getFloat("discount");
            Promotion promo = new Promotion();
            promo.setPromoCode(promoCode);
            promo.setAvailableFrom(availableFrom);
            promo.setAvailableUntil(availableUntil);
            promo.setDiscount(discount);
            return promo;
        }
        return null;
    }
	
	public static Booking findBooking(Connection conn, int bookingId) throws SQLException {
		String sql = "Select a.id, a.passenger_id, a.num_of_passenger, a.total_price, a.flight_id from booking a "//
                + " where a.id = ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, bookingId);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
        	int passengerId = rs.getInt("passenger_id");
        	int numOfPassenger = rs.getInt("num_of_passenger");
        	float totalPrice = rs.getFloat("total_price");
        	int flightId = rs.getInt("flight_id");
            Booking booking = new Booking();
            booking.setID(bookingId);
            booking.setPassengerID(passengerId);
            booking.setNumOfPassenger(numOfPassenger);
            booking.setTotalPrice(totalPrice);
            booking.setFlightID(flightId);
            return booking;
        }
        return null;
    }
	
	public static int updateBooking(Connection conn, Booking booking) throws SQLException {
        String sql = "Update booking set total_price = ? where id=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setFloat(1, booking.getTotalPrice());
        pstm.setInt(3, booking.getID());
        int result = pstm.executeUpdate();
        return result;
    }
	
	public static Booking insertBooking(Connection conn, Booking booking) throws SQLException {
        String sql = "Insert into booking(passenger_id, num_of_passenger, total_price, flight_id) values (?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, booking.getPassengerID());
        pstm.setInt(2, booking.getNumOfPassenger());
        pstm.setFloat(3, booking.getTotalPrice());
        pstm.setInt(4, booking.getFlightID());
        pstm.executeUpdate();
        ResultSet generatedKeys = pstm.getGeneratedKeys();
        if (generatedKeys.next()) {
            booking.setID(generatedKeys.getInt(1));
        }
        return booking;
    }
	
	public static int deleteBooking(Connection conn, int bookingId) throws SQLException {
        String sql = "Delete From booking where id= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, bookingId);
 
        int res = pstm.executeUpdate();
        return res;
    }
	
	public static int insertTicket(Connection conn, Ticket ticket) throws SQLException {
        String sql = "Insert into ticket(ticket_code, passenger_id, booking_id) values (?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, ticket.getTicketCode());
        pstm.setInt(2, ticket.getPassengerID());
        pstm.setInt(3, ticket.getBookingID());
        int res = pstm.executeUpdate();
        
        return res;
    }
	
	
}
