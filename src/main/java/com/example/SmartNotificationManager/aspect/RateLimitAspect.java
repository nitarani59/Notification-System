package com.example.SmartNotificationManager.aspect;

import com.example.SmartNotificationManager.exception.GlobalExceptionHandler;
import com.example.SmartNotificationManager.exception.RateLimitException;
import com.example.SmartNotificationManager.service.rateLimit.RateLimiterService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RateLimitAspect {

    @Autowired
    RateLimiterService rateLimiterService;

    @Before("@annotation(com.example.SmartNotificationManager.aspect.annotation.RateLimit)")
    public void rateLimit() {
        System.out.println("Inside Rate Limit");
        if (!rateLimiterService.allowedRequest()) {
            throw new RateLimitException();
        }
    }
}
