package com.flightbooking.ws.FlightBookingService.ApplyPromo;

import java.sql.SQLException;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.flightbooking.beans.Promotion;
import com.flightbooking.utils.DBUtils;

public class CheckDateValidityDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		Promotion promo = (Promotion)execution.getVariable("Promo");
		long now = new java.util.Date().getTime();
		if(now > promo.getAvailableUntil().getTime()) {
			execution.setVariable("valid", false);
		} else {
			execution.setVariable("valid", true);
		}
	}

}
