package com.example.LogingDemo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class LogingDemoApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogingDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LogingDemoApplication.class, args);

		LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
	}
}
