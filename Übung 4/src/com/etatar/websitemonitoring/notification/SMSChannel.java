package com.etatar.websitemonitoring.notification;

import com.etatar.websitemonitoring.model.User;

public class SMSChannel implements NotificationChannel {
    @Override
    public void send(User user, String message) {
        System.out.println("Sending SMS to " + user.getEmail() + ": " + message);
    }
}


