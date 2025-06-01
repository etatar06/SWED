package com.etatar.websitemonitoring.notification;

import com.etatar.websitemonitoring.model.User;

public class PushNotificationChannel implements NotificationChannel {
    @Override
    public void send(User user, String message) {
        System.out.println("Sending Push com.etatar.websitemonitoring.notification.Notification to " + user.getEmail() + ": " + message);
    }
}


