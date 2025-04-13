package com.example.SmartNotificationManager.service.impl;

import com.example.SmartNotificationManager.dto.NotificationDto;
import com.example.SmartNotificationManager.service.NotificationService;
import org.springframework.stereotype.Service;

@Service("push")
public class PushNotificationService implements NotificationService {
    @Override
    public String sendNotification(NotificationDto notificationDto) {
        return notificationDto.getType() + " PUSH Notification";
    }
}
