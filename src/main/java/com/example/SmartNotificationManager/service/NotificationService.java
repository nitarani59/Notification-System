package com.example.SmartNotificationManager.service;

import com.example.SmartNotificationManager.dto.NotificationDto;

public interface NotificationService {
    String sendNotification(NotificationDto notificationDto);
}
