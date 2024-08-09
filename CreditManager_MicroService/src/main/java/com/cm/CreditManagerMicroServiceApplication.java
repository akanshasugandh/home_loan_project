package com.cm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreditManagerMicroServiceApplication {

	public static void main(String[] args) {
		System.out.println("MicroService for Credit Manager");
		SpringApplication.run(CreditManagerMicroServiceApplication.class, args);
	}

}
