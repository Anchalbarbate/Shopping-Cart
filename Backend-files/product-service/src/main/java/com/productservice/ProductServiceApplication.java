package com.productservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {
	
	private static final Logger logger=LoggerFactory.getLogger(ProductServiceApplication.class);

	public static void main(String[] args) {
				
		logger.info("Starting Product Service Application.....");
		
		SpringApplication.run(ProductServiceApplication.class, args);
		
		logger.info("Product Service Application started successfully");
		
	}
	
	
	

}
