package com.example.SmartNotificationManager.controller;

import com.example.SmartNotificationManager.dto.NotificationDto;
import com.example.SmartNotificationManager.service.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Tag(name = "Notification API")
public class NotificationController {

    Map<String, NotificationService> notificationService;
    @Autowired
//    @Qualifier("push")
    NotificationService notificationService1;

    public NotificationController(Map<String, NotificationService> notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    @Operation(summary = "Send Notification")
    public String sendNotification(@RequestBody NotificationDto notification) {
        String type = notification.getType().toLowerCase(); // e.g., "sms", "email", "push"
        NotificationService notificationService2 =  notificationService.getOrDefault(type, notificationService.get("sms"));
        return notificationService2.sendNotification(notification);
    }
}
