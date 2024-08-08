package com.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerLoginMicroServiceApplication {

	public static void main(String[] args) {
		System.out.println("MicroService for Customer Login");
		SpringApplication.run(CustomerLoginMicroServiceApplication.class, args);
	}

}
