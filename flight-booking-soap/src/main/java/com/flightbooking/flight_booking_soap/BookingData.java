//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.11.28 at 03:46:13 AM ICT 
//


package com.flightbooking.flight_booking_soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bookingData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bookingData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numOfPassenger" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="passengerId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="flightId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookingData", propOrder = {
    "numOfPassenger",
    "passengerId",
    "flightId"
})
public class BookingData {

    protected int numOfPassenger;
    protected int passengerId;
    protected int flightId;

    /**
     * Gets the value of the numOfPassenger property.
     * 
     */
    public int getNumOfPassenger() {
        return numOfPassenger;
    }

    /**
     * Sets the value of the numOfPassenger property.
     * 
     */
    public void setNumOfPassenger(int value) {
        this.numOfPassenger = value;
    }

    /**
     * Gets the value of the passengerId property.
     * 
     */
    public int getPassengerId() {
        return passengerId;
    }

    /**
     * Sets the value of the passengerId property.
     * 
     */
    public void setPassengerId(int value) {
        this.passengerId = value;
    }

    /**
     * Gets the value of the flightId property.
     * 
     */
    public int getFlightId() {
        return flightId;
    }

    /**
     * Sets the value of the flightId property.
     * 
     */
    public void setFlightId(int value) {
        this.flightId = value;
    }

}
