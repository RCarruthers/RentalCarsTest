package com.ryan.uom.RentalCarsTest;

import org.apache.camel.Producer;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.*;

import static com.ryan.uom.RentalCarsTest.util.Constants.ENDPOINT_START_ROUTE;

@SpringBootApplication
public class RentalCarsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalCarsTestApplication.class, args);
	}


	@RestController
	class Controller {

		@Autowired
		ProducerTemplate producer;

		@RequestMapping("/hello")
		public String greeting() {
			Object exchange = producer.requestBody(ENDPOINT_START_ROUTE, "First test.");
			return (String) exchange;
		}

		@RequestMapping("/bye")
		public String greeting2() {
			Object exchange = producer.requestBody("direct:bye", "First test.");
			return (String) exchange;
		}
	}
}
