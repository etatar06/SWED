package com.etatar.websitemonitoring.notification;

import com.etatar.websitemonitoring.model.Subscription;

import java.time.LocalDateTime;

public class Notification {
    private static int counter = 1;

    private int notificationId;
    private String message;
    private LocalDateTime timestamp;
    private Subscription subscription;

    public Notification(String message, Subscription subscription) {
        this.notificationId = counter++;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.subscription = subscription;
    }

    // Deliver the notification using the user's chosen channel
    public void deliver() {
        subscription.getChannel().send(subscription.getUser(), message);
    }
}
