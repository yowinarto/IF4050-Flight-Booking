package com.flightbooking.flightbookingsoap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class FlightBookingSoap extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FlightBookingSoap.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(FlightBookingSoap.class, args);
	}
}
