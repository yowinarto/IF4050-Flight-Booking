package com.flightbooking.flightbookingsoap.service;

import com.flightbooking.flight_booking_soap.BookingData;
import com.flightbooking.flight_booking_soap.PromoData;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private static final String addr = "http://178.128.80.25:8080/engine-rest/message";

    public static void postBookingData(BookingData data) {
        try {
            System.out.println("sending booking data");

            JSONObject processVariables = new JSONObject();
            JSONObject val = new JSONObject();
            val.put("value", data.getNumOfPassenger());
            val.put("type", "Integer");
            processVariables.put("numOfPassenger", val);
            val = new JSONObject();
            val.put("value", data.getPassengerId());
            val.put("type", "Integer");
            processVariables.put("passengerId", val);
            val = new JSONObject();
            val.put("value", data.getFlightId());
            val.put("type", "Integer");
            processVariables.put("flightId", val);

            JSONObject bodyRequest = new JSONObject();
            bodyRequest.put("messageName", "Booking Ticket");
            bodyRequest.put("businessKey", "12345");
            bodyRequest.put("processVariables", processVariables);
            bodyRequest.put("resultEnabled", true);

            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost request = new HttpPost(addr);
            StringEntity params = new StringEntity(bodyRequest.toString());

            System.out.println(bodyRequest.toString());

            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            httpClient.execute(request);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void postPromoData(PromoData data) {
        try {
            System.out.println("sending apply promo data");

            JSONObject processVariables = new JSONObject();
            JSONObject val = new JSONObject();
            val.put("value", data.getPromoCode());
            val.put("type", "String");
            processVariables.put("promoCode", val);
            val = new JSONObject();
            val.put("value", data.getBookingId());
            val.put("type", "Integer");
            processVariables.put("bookingId", val);

            JSONObject bodyRequest = new JSONObject();
            bodyRequest.put("messageName", "Apply Promo");
            bodyRequest.put("businessKey", "12345");
            bodyRequest.put("processVariables", processVariables);
            bodyRequest.put("resultEnabled", true);

            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost request = new HttpPost(addr);
            StringEntity params = new StringEntity(bodyRequest.toString());

            System.out.println(bodyRequest.toString());

            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            httpClient.execute(request);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void postCancelBookingData(int data) {
        try {
            System.out.println("sending cancel booking data");

            JSONObject processVariables = new JSONObject();
            JSONObject val = new JSONObject();
            val.put("value", data);
            val.put("type", "Integer");
            processVariables.put("bookingId", val);

            JSONObject bodyRequest = new JSONObject();
            bodyRequest.put("messageName", "Cancel Booking");
            bodyRequest.put("businessKey", "12345");
            bodyRequest.put("processVariables", processVariables);
            bodyRequest.put("resultEnabled", true);

            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost request = new HttpPost(addr);
            StringEntity params = new StringEntity(bodyRequest.toString());

            System.out.println(bodyRequest.toString());

            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            httpClient.execute(request);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
