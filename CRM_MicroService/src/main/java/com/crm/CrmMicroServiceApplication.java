package com.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CrmMicroServiceApplication {

	public static void main(String[] args) {
		System.out.println("CRM MicroService for Home Loan");
		SpringApplication.run(CrmMicroServiceApplication.class, args);
	}

}
