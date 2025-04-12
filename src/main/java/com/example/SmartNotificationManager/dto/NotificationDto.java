package com.example.SmartNotificationManager.dto;

public class NotificationDto {
    private String type;
    private String message;

    public NotificationDto(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationDto() {
    }
}
