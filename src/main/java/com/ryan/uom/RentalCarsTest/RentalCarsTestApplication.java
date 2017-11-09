package com.ryan.uom.RentalCarsTest;

import org.apache.camel.Producer;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.ryan.uom.RentalCarsTest.util.Constants.*;

@SpringBootApplication
public class RentalCarsTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentalCarsTestApplication.class, args);
    }

    @RestController
    class Controller {

        @Autowired
        ProducerTemplate producer;

        @RequestMapping(value = {REQUEST_PATH_PRICE, REQUEST_PATH_SIPP, REQUEST_PATH_RATING, REQUEST_PATH_SCORE})
        public String greeting(Model model, HttpServletRequest request) {
            Object exchange = producer.requestBody(ENDPOINT_START_ROUTE, request.getServletPath());
            return (String) exchange;
        }
    }
}
