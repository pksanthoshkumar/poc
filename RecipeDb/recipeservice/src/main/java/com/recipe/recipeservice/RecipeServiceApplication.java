package com.recipe.recipeservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class RecipeServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(RecipeServiceApplication.class, args);
	}
}