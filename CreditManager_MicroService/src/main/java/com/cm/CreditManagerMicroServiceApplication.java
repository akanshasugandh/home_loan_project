package com.cm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class CreditManagerMicroServiceApplication {

	public static void main(String[] args) {
		System.out.println("Credit Manager MicroService for Home loan");
		SpringApplication.run(CreditManagerMicroServiceApplication.class, args);
	}

}
