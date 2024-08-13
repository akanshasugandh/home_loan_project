package com.ach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class AccountHeadMicroServiceApplication {

	public static void main(String[] args) {
		System.out.println("AccountHead_MicroService for Home loan");
		SpringApplication.run(AccountHeadMicroServiceApplication.class, args);
	}

}
