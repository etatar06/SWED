package com.etatar.websitemonitoring.model;

import com.etatar.websitemonitoring.notification.NotificationChannel;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static int counter = 1;

    private int userId;
    private String name;
    private String email;
    private List<Subscription> subscriptions;

    public User(String name, String email) {
        this.userId = counter++;
        this.name = name;
        this.email = email;
        this.subscriptions = new ArrayList<>();
    }

    public void subscribe(String frequency, NotificationChannel channel, Website website) {
        Subscription subscription = new Subscription(frequency, channel, this, website);
        subscriptions.add(subscription);
    }

    public void unsubscribe(Subscription subscription) {
        subscription.unsubscribe();
        subscriptions.remove(subscription);
    }

    public void updateSubscription(Subscription subscription, String frequency, NotificationChannel channel) {
        subscription.setFrequency(frequency);
        subscription.setChannel(channel);
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
