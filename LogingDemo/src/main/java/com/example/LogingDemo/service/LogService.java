package com.example.LogingDemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogService {
    public String testLogService () {
        log.trace("A TRACE Message from Service");
        log.debug("A DEBUG Message from Service");
        log.info("A DEBUG Message from Service");
        log.error("A DEBUG Message from Service");
        return "I am logging from Service";
    }
}
