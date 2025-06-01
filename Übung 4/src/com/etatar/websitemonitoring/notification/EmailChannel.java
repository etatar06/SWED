package com.etatar.websitemonitoring.notification;

import com.etatar.websitemonitoring.model.User;

public class EmailChannel implements NotificationChannel {
    @Override
    public void send(User user, String message) {
        System.out.println("Sending Email to " + user.getEmail() + ": " + message);
    }
}

