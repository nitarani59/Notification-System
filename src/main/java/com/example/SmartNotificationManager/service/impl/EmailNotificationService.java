package com.example.SmartNotificationManager.service.impl;

import com.example.SmartNotificationManager.constant.MailStatus;
import com.example.SmartNotificationManager.dto.NotificationDto;
import com.example.SmartNotificationManager.entity.NotificationHistory;
import com.example.SmartNotificationManager.repository.NotificationRepository;
import com.example.SmartNotificationManager.service.NotificationService;
import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service("email")
public class EmailNotificationService implements NotificationService {

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.from}")
    String from;

    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public String sendNotification(NotificationDto notificationDto) {
        NotificationHistory notificationHistory = new NotificationHistory();
        notificationHistory.setToAddress(notificationDto.getTo());
        notificationHistory.setMessage(notificationDto.getMessage());
        notificationHistory.setType(notificationDto.getType());
        notificationHistory.setFromAddress(from);
        notificationHistory.setCreatedAt(Instant.now().toString());
        try {
            javaMailSender.send(mimeMessage -> {
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(notificationDto.getTo()));
                mimeMessage.setSubject("Notification");
                mimeMessage.setText(notificationDto.getMessage());
            });
        }
        catch (Exception e) {
            notificationHistory.setStatus(MailStatus.FAILED);
            notificationRepository.save(notificationHistory);
            return "Failed to send email notification to " + notificationDto.getTo();
        }
        notificationHistory.setStatus(MailStatus.SENT);
        notificationRepository.save(notificationHistory);
        return "Email notification successfully sent to " + notificationDto.getTo();
    }
}
