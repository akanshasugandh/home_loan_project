package com.oe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OeMicroServiceApplication {

	public static void main(String[] args) {
		System.out.println("MicroService for OE");
		SpringApplication.run(OeMicroServiceApplication.class, args);
	}

}
