package com.example.SmartNotificationManager.config;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twilio")
public class TwilioConfiguration {

    private String accountSid;
    private String authToken;
    private String fromNumber;

    @PostConstruct
    public void intialize() {
        Twilio.init(accountSid, authToken);
    }

    public String getAccountSid() {
        return accountSid;
    }

    public String getFromNumber() {
        return fromNumber;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public void setFromNumber(String fromNumber) {
        this.fromNumber = fromNumber;
    }
}

