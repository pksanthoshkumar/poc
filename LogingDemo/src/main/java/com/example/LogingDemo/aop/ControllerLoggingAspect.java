package com.example.LogingDemo.aop;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
//@Log4j2
@Aspect
@Component
class ControllerLoggingAspect {

    @Around("execution(* com.example.LogingDemo.controller.LombokLoggingController.*(..))")
    public void logControllerMethods (ProceedingJoinPoint joinPoint) throws Exception {

        try {
            log.info("Entering : " + joinPoint.getSignature().getName() );
            joinPoint.proceed();
            log.info("Exiting : " + joinPoint.getSignature().getName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
