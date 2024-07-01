package com.cartservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CartServiceApplication {

	private static final Logger logger=LoggerFactory.getLogger(CartServiceApplication.class);
	public static void main(String[] args) {
		
		logger.info("Starting Cart Service Application.....");
		SpringApplication.run(CartServiceApplication.class, args);
		
		
		logger.info("Cart Service Ended.....");
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
