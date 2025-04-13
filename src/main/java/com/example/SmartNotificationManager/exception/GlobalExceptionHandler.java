package com.example.SmartNotificationManager.exception;

import com.example.SmartNotificationManager.error.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RateLimitException.class)
    public ResponseEntity<ErrorResponse> handleRateLimitException() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(429);
        errorResponse.setMessage("Rate limit exceeded. Please try again later.");
        return ResponseEntity.ok(errorResponse);
    }
}
