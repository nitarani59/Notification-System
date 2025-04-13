package com.example.SmartNotificationManager.exception;

public class RateLimitException extends RuntimeException {

    public RateLimitException() {
        super("Rate limit exceeded. Please try again later.");
    }

    public RateLimitException(String message) {
        super(message);
    }
}
