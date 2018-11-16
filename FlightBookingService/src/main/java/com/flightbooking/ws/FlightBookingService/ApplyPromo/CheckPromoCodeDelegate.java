package com.flightbooking.ws.FlightBookingService.ApplyPromo;

import java.sql.Connection;
import java.sql.SQLException;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.flightbooking.beans.Promotion;
import com.flightbooking.conn.ConnectionUtils;
import com.flightbooking.utils.DBUtils;

public class CheckPromoCodeDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String promoCode = (String)execution.getVariable("promoCode");
		Promotion promo = null;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
            promo = DBUtils.findPromo(conn, promoCode);
            
        } catch (Exception e) {
            e.printStackTrace();
            ConnectionUtils.rollbackQuietly(conn);
        } finally {
        	ConnectionUtils.closeQuietly(conn);
        }
        
		if(promo == null) {
			execution.setVariable("code", false);
		} else {
			execution.setVariable("code", true);
			execution.setVariable("Promo", promo);
		}
		
	}

}
