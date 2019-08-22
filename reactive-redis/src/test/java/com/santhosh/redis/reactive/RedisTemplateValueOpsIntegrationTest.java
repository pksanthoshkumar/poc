package com.santhosh.redis.reactive;

import java.io.IOException;
import java.time.Duration;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.santhosh.redis.model.Account;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import redis.embedded.RedisServerBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringRedisReactiveApplication.class)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
public class RedisTemplateValueOpsIntegrationTest {
    
    private static redis.embedded.RedisServer redisServer;

    @Autowired
    private ReactiveRedisTemplate<String, Account> redisTemplate;

    private ReactiveValueOperations<String, Account> reactiveValueOps;
    
    @BeforeClass
    public static void startRedisServer() throws IOException {
        redisServer = new RedisServerBuilder().port(6379).setting("maxheap 256M").build();
        redisServer.start();
    }
    
    @AfterClass
    public static void stopRedisServer() throws IOException {
        redisServer.stop();
    }

    @Before
    public void setup() {
        reactiveValueOps = redisTemplate.opsForValue();
    }

    @Test
    public void givenEmployee_whenSet_thenSet() {

        Mono<Boolean> result = reactiveValueOps.set("123", new Account(1L, "1234567890", 2000));


        StepVerifier.create(result)
            .expectNext(true)
            .verifyComplete();
    }

    @Test
    public void givenAccountId_whenGet_thenReturnsAccount() {
    	
        Mono<Account> fetchedAccount = reactiveValueOps.get("123");
        
        //Account account = fetchedEmployee.block();

        StepVerifier.create(fetchedAccount)
            .expectNext(new Account(1L, "1234567890", 2000))
            .verifyComplete();
    }

    @Test
    public void givenEmployee_whenSetWithExpiry_thenSetsWithExpiryTime() throws InterruptedException {

        Mono<Boolean> result = reactiveValueOps.set("129", new Account(1L, "1234567890", 2000), Duration.ofSeconds(1));
        Mono<Account> fetchedAccount = reactiveValueOps.get("129");

        StepVerifier.create(result)
            .expectNext(true)
            .verifyComplete();

        Thread.sleep(2000L);

        StepVerifier.create(fetchedAccount)
            .expectNextCount(0L)
            .verifyComplete();
    }

}
