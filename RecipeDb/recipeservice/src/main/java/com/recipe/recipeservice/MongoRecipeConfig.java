package com.recipe.recipeservice;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@Log4j2
public class MongoRecipeConfig extends AbstractReactiveMongoConfiguration {
    @Override
    public MongoClient reactiveMongoClient() {
        log.info ("Creating Mongo Client");
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        log.info ("Using Mongo Database Recipe DB");
        return "RecipeDB";
    }
}
