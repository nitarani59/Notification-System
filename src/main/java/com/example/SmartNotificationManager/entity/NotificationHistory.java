package com.example.SmartNotificationManager.entity;

import com.example.SmartNotificationManager.constant.MailStatus;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class NotificationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String message;
    private String toAddress;
    private String fromAddress;
    private String createdAt;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public NotificationHistory() {
    }

    public String getStatus() {
        return status.toString();
    }

    public void setStatus(MailStatus status) {
        this.status = String.valueOf(status);
    }
}
