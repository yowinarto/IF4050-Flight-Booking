package com.flightbooking.flightbookingsoap.endpoint;

import com.flightbooking.flight_booking_soap.*;
import com.flightbooking.flightbookingsoap.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BookingEndpoint {

    @Autowired
    private BookingService bookingService;

    @PayloadRoot(namespace = "http://flightbooking.com/flight-booking-soap",
            localPart = "postBookingRequest")
    @ResponsePayload
    public PostBookingResponse postBookingRequest(@RequestPayload PostBookingRequest request) {
        PostBookingResponse response = new PostBookingResponse();
        BookingService.postBookingData(request.getBookingData());
        response.setMessage("ok");
        return response;
    }

    @PayloadRoot(namespace = "http://flightbooking.com/flight-booking-soap",
            localPart = "postPromoRequest")
    @ResponsePayload
    public PostPromoResponse postPromoRequest(@RequestPayload PostPromoRequest request) {
        PostPromoResponse response = new PostPromoResponse();
        BookingService.postPromoData(request.getPromoData());
        response.setMessage("ok");
        return response;
    }

    @PayloadRoot(namespace = "http://flightbooking.com/flight-booking-soap",
            localPart = "postCancelBookingRequest")
    @ResponsePayload
    public PostCancelBookingResponse postCancelBookingRequest(@RequestPayload PostCancelBookingRequest request) {
        PostCancelBookingResponse response = new PostCancelBookingResponse();
        BookingService.postCancelBookingData(request.getBookingId());
        response.setMessage("ok");
        return response;
    }
}
