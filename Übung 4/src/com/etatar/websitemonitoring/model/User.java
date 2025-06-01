package com.etatar.websitemonitoring.model;
import com.etatar.websitemonitoring.notification.NotificationChannel;
import com.etatar.websitemonitoring.model.Subscription;

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

    // Subscribe to a website
    public void subscribe(String frequency, NotificationChannel channel, Website website) {
        Subscription subscription = new Subscription(frequency, channel, this, website);
        subscriptions.add(subscription);
    }

    // Unsubscribe from a specific subscription
    public void unsubscribe(Subscription subscription) {
        subscriptions.remove(subscription);
    }

    // Update subscription frequency or channel
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
