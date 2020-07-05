package com.example.LogingDemo.service;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
//@Log4j2
public class LogService {
    public String testLogService (String param) {
        log.trace("A TRACE Message from Service");
        log.debug("A DEBUG Message from Service");
        log.info("A DEBUG Message from Service");
        log.error("A DEBUG Message from Service");
        return "I am logging from Service";
    }
}
