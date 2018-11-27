package com.flightbooking.flightbookingsoap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/flight/*");
    }

    @Bean
    public XsdSchema bookingSchema() {
        return new SimpleXsdSchema(new ClassPathResource("flightbooking.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema bookingSchema) {

        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(bookingSchema);
        definition.setLocationUri("/flight/booking");
        definition.setPortTypeName("FlightBookingServicePort");
        definition.setTargetNamespace("http://flightbooking.com/flight-booking-soap");
        return definition;
    }

    @Bean
    public XsdSchema applyPromoSchema() {
        return new SimpleXsdSchema(new ClassPathResource("applypromo.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition2(XsdSchema applyPromoSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(applyPromoSchema);
        definition.setLocationUri("/flight/apply-promo");
        definition.setPortTypeName("FlightBookingServicePort2");
        definition.setTargetNamespace("http://flightbooking.com/flight-booking-soap");
        return definition;
    }

    @Bean
    public XsdSchema cancelBookingSchema() {
        return new SimpleXsdSchema(new ClassPathResource("cancelbooking.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition3(XsdSchema cancelBookingSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(cancelBookingSchema);
        definition.setLocationUri("/flight/cancel-booking");
        definition.setPortTypeName("FlightBookingServicePort3");
        definition.setTargetNamespace("http://flightbooking.com/flight-booking-soap");
        return definition;
    }
}
