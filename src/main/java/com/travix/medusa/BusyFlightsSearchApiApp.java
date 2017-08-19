package com.travix.medusa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.travix.medusa"})// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class BusyFlightsSearchApiApp {

	public static void main(String[] args) {
		SpringApplication.run(BusyFlightsSearchApiApp.class, args);
	}
}
