package com.example.SmartNotificationManager.service.rateLimit;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class RateLimiterService {

    private RateLimiterInfo rateLimiterInfo;
    private final int MAX_TOKEN = 2;
    private final int REFILL_TIME = 30000;

    @PostConstruct
    public void init() {
        rateLimiterInfo = new RateLimiterInfo(MAX_TOKEN, System.currentTimeMillis());
    }

    public boolean allowedRequest() {
        refill();
        if (rateLimiterInfo.getToken() > 0) {
            rateLimiterInfo.setToken(rateLimiterInfo.getToken() - 1);
            return true;
        }
        return false;
    }

    private void refill() {
        long elapsedTime = System.currentTimeMillis() - rateLimiterInfo.getLastRefillTime();
        int tokensToAdd = (int) (elapsedTime / REFILL_TIME);
        if (tokensToAdd > 0) {
            rateLimiterInfo.setToken(Math.min((rateLimiterInfo.getToken())+tokensToAdd, MAX_TOKEN));
            long newRefillTime = rateLimiterInfo.getLastRefillTime() + tokensToAdd * REFILL_TIME;
            rateLimiterInfo.setLastRefillTime(newRefillTime);
        }
    }
}
