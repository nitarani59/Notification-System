package com.example.SmartNotificationManager.service.rateLimit;

public class RateLimiterInfo {
    private int token;
    private long lastRefillTime;

    public RateLimiterInfo(int token, long lastRefillTime) {
        this.token = token;
        this.lastRefillTime = lastRefillTime;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public long getLastRefillTime() {
        return lastRefillTime;
    }

    public void setLastRefillTime(long lastRefillTime) {
        this.lastRefillTime = lastRefillTime;
    }
}
