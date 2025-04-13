package com.example.SmartNotificationManager.repository;

import com.example.SmartNotificationManager.entity.NotificationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationHistory, Long> {
}
