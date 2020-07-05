package com.example.LogingDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class LogingDemoApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogingDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LogingDemoApplication.class, args);

		LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
	}
}
