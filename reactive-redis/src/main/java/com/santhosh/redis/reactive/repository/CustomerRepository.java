package com.santhosh.redis.reactive.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.santhosh.redis.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByExternalId(String externalId);
    List<Customer> findByAccountsId(Long id);
}
