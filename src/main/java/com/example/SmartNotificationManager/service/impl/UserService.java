package com.example.SmartNotificationManager.service.impl;

import com.example.SmartNotificationManager.dto.UserDto;
import com.example.SmartNotificationManager.entity.User;
import com.example.SmartNotificationManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements com.example.SmartNotificationManager.service.UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String registerUser(UserDto user) {
        User user1 = new User();
        user1.setId(user.getId());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setAddress(user.getAddress());
        user1.setRole(user.getRole());
        user1.setStatus(user.getStatus());
        user1.setCreatedAt(user.getCreatedAt());
        user1.setUpdatedAt(user.getUpdatedAt());
        userRepository.save(user1);
        return "User Created";
    }
}
