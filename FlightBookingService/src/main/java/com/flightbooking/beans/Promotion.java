package com.flightbooking.beans;
import java.io.Serializable;
import java.sql.Date;
public class Promotion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String promo_code;
	private Date available_from;
	private Date available_until;
	private float discount;
	public String getPromoCode() {
		return promo_code;
	}
	public void setPromoCode(String promo_code) {
		this.promo_code = promo_code;
	}
	public Date getAvailableFrom() {
		return available_from;
	}
	public void setAvailableFrom(Date available_from) {
		this.available_from = available_from;
	}
	public Date getAvailableUntil() {
		return available_until;
	}
	public void setAvailableUntil(Date available_until) {
		this.available_until = available_until;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	@Override
	public String toString() {
		return promo_code + "::" + available_from + "::" + available_until + "::" + discount;
	}
}
