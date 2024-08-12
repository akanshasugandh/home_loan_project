package com.oe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableDiscoveryClient
@SpringBootApplication
public class OeMicroServiceApplication {

	public static void main(String[] args) {
		System.out.println("OE MicroService for Home loan ");
		SpringApplication.run(OeMicroServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate rsTemplate() {
		RestTemplate rs=new RestTemplate();
		return rs;
	}

}
