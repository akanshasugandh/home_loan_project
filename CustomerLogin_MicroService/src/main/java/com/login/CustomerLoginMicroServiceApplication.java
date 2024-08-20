package com.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CustomerLoginMicroServiceApplication {

	public static void main(String[] args) {
		System.out.println("Customer Login MicroService for Home loan");
		SpringApplication.run(CustomerLoginMicroServiceApplication.class, args);
	}

}
