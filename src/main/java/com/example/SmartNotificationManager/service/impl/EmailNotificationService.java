package com.example.SmartNotificationManager.service.impl;

import com.example.SmartNotificationManager.service.NotificationService;
import org.springframework.stereotype.Service;

@Service("email")
public class EmailNotificationService implements NotificationService {
    @Override
    public String sendNotification(String type) {
        return type + " Email Notification";
    }
}
