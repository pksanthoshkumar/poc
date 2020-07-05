package com.example.LogingDemo.controller;

import com.example.LogingDemo.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LombokLoggingController {

    @Autowired
    LogService logService;

    @RequestMapping("/lombok")
    public String index() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        log.info("Calling info servie " + logService.testLogService());

        return "Howdy! Check out the Logs to see the output...";
    }
}
