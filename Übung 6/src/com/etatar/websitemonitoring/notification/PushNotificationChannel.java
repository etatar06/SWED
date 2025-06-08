package com.etatar.websitemonitoring.notification;

import com.etatar.websitemonitoring.model.User;

public class PushNotificationChannel implements NotificationChannel {
    @Override
    public void update(User user, String message) {
        System.out.println("Sending Push Notification to " + user.getEmail() + ": " + message);
    }
}
