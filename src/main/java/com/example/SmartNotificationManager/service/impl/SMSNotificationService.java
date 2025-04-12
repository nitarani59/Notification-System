package com.example.SmartNotificationManager.service.impl;

import com.example.SmartNotificationManager.service.NotificationService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("sms")
@Primary
public class SMSNotificationService implements NotificationService {
    @Override
    public String sendNotification(String type) {
        return type + " SMS Notification";
    }
}
