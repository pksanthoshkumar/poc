package com.santhosh.redis.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories

public class SpringRedisReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisReactiveApplication.class, args);
    }

}