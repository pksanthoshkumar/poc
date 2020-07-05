package com.example.LogingDemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
class ServiceLoggingAspect {

    @Around("execution(public * com.example.LogingDemo.service.LogService.*(..))")
    public void logServiceMethods (ProceedingJoinPoint joinPoint) throws Exception {
        long start = System.currentTimeMillis();

        try {
            log.info("Entering : " + joinPoint.getSignature().getName() + " with arguments " + joinPoint.getArgs());
            joinPoint.proceed();
            long executionTime = System.currentTimeMillis() - start;
            log.info("Exiting : " + joinPoint.getSignature().getName() + " after " + executionTime + " sec");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
