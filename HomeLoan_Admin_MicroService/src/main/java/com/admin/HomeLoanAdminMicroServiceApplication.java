package com.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HomeLoanAdminMicroServiceApplication {

	public static void main(String[] args) {
		System.out.println("MicroService for HomeLoan Admin");
		SpringApplication.run(HomeLoanAdminMicroServiceApplication.class, args);
	}
	@Bean
	public RestTemplate restT()
	{
		RestTemplate rs=new RestTemplate();
		return rs;
	}


}
