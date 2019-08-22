package com.santhosh.redis.reactive.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santhosh.redis.model.Customer;
import com.santhosh.redis.reactive.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
    
    @Autowired
    CustomerRepository repository;

    @PostMapping
    public Customer add(@RequestBody Customer customer) {
    	LOGGER.info ("Adding Customer " + customer.getExternalId());
        return repository.save(customer);
    }

    @GetMapping("/{externalId}")
    public Customer findById(@PathVariable("externalId") String externalId) {
    	LOGGER.info ("Getting Customer " + externalId);

        Customer optCustomer = repository.findByExternalId(externalId);
        
        if (Optional.ofNullable(optCustomer).isPresent())
            return optCustomer;
        else{
        	LOGGER.info ("Customer " + externalId + " not foud");
            return null;
        }
    }

}
