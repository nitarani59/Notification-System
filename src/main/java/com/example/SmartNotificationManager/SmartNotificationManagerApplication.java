package com.example.SmartNotificationManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SmartNotificationManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartNotificationManagerApplication.class, args);
	}

}
