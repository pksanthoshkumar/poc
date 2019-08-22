package com.santhosh.redis.reactive.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santhosh.redis.model.Customer;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers/rx")
public class CustomerControllerRx {
    private final Logger LOGGER = LoggerFactory.getLogger(CustomerControllerRx.class);
    
    @Autowired
    private ReactiveRedisTemplate<String, Customer> redisTemplate;
    
    private ReactiveValueOperations<String, Customer> reactiveValueOps;
    
	@PostMapping
	public Mono<Boolean> add(@RequestBody Customer customer) {
		LOGGER.info("Adding Customer Rx : " + customer.getExternalId());
		
		reactiveValueOps = redisTemplate.opsForValue();
        Mono<Boolean> result = reactiveValueOps.set(customer.getExternalId(), customer);
		return result;
	}

	@GetMapping("/{id}")
	public Mono<Customer> findById(@PathVariable("id") String id) {
		LOGGER.info ("Getting Customer Rx : " + id);
		
		reactiveValueOps = redisTemplate.opsForValue();
		Mono<Customer> fetchedAccount = reactiveValueOps.get(id);
		return fetchedAccount;
	}
}
