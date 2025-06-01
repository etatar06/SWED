package com.etatar.websitemonitoring.model;

import com.etatar.websitemonitoring.notification.NotificationChannel;


public class Subscription {
    private static int counter = 1;

    private int subscriptionId;
    private String frequency;
    private NotificationChannel channel;
    private User user;
    private Website website;

    public Subscription(String frequency, NotificationChannel channel, User user, Website website) {
        this.subscriptionId = counter++;
        this.frequency = frequency;
        this.channel = channel;
        this.user = user;
        this.website = website;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public NotificationChannel getChannel() {
        return channel;
    }

    public void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }

    public Website getWebsite() {
        return website;
    }

    public User getUser() {
        return user;
    }
}
