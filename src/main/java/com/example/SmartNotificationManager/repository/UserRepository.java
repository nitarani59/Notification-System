package com.example.SmartNotificationManager.repository;

import com.example.SmartNotificationManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
