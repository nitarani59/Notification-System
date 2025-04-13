package com.example.SmartNotificationManager.service.impl;

import com.example.SmartNotificationManager.config.TwilioConfiguration;
import com.example.SmartNotificationManager.constant.MailStatus;
import com.example.SmartNotificationManager.dto.NotificationDto;
import com.example.SmartNotificationManager.entity.NotificationHistory;
import com.example.SmartNotificationManager.repository.NotificationRepository;
import com.example.SmartNotificationManager.service.NotificationService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service("sms")
@Primary
public class SMSNotificationService implements NotificationService {

    @Autowired
    TwilioConfiguration twilioConfiguration;

    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public String sendNotification(NotificationDto notificationDto) {
        NotificationHistory notificationHistory = new NotificationHistory();
        notificationHistory.setToAddress(notificationDto.getTo());
        notificationHistory.setMessage(notificationDto.getMessage());
        notificationHistory.setType(notificationDto.getType());
        notificationHistory.setFromAddress(twilioConfiguration.getFromNumber());
        notificationHistory.setCreatedAt(Instant.now().toString());
        // Use Twilio to send the SMS
        // Create and send SMS
        int maxAttempts = 3;
        int attempt = 0;
        long baseDelay = 2000;
        Message message = null;
        while (attempt < maxAttempts) {
            try {
                message = Message.creator(
                        new PhoneNumber(notificationDto.getTo()), // To
                        new PhoneNumber(twilioConfiguration.getFromNumber()), // From
                        notificationDto.getMessage()
                ).create(); // Sends the message
                notificationHistory.setStatus(MailStatus.SENT);
                notificationRepository.save(notificationHistory);
                return "SMS Notification sent to 8709915568 with Status: " + message.getStatus();
            } catch (Exception e) {
                attempt++;
                if (attempt >= maxAttempts) {
                    notificationHistory.setStatus(MailStatus.valueOf(MailStatus.FAILED.name()));
                    notificationRepository.save(notificationHistory);
                }
            }
            // Adding exponential backoff
            try {
                double delay = baseDelay * Math.pow(2, (attempt - 1));
                Thread.sleep((long) delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return "Failed to send email notification to " + notificationDto.getTo();
    }
}
