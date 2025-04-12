package com.example.SmartNotificationManager.controller;

import com.example.SmartNotificationManager.dto.UserDto;
import com.example.SmartNotificationManager.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "User API")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    @Operation(summary = "Register user")
    public String createUser(@RequestBody UserDto user) {
        return userService.registerUser(user);
    }
}
