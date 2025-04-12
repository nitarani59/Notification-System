package com.example.SmartNotificationManager.service.impl;

import com.example.SmartNotificationManager.service.NotificationService;
import org.springframework.stereotype.Service;

@Service("push")
public class PushNotificationService implements NotificationService {
    @Override
    public String sendNotification(String type) {
        return type + " PUSH Notification";
    }
}
