package com.etatar.websitemonitoring.model;

import com.etatar.websitemonitoring.notification.NotificationChannel;
import com.etatar.websitemonitoring.observer.Observer;

public class Subscription implements Observer {
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

        // Website'ye abone ol
        this.website.registerObserver(this);
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

    // Observer interface metodu: güncelleme geldiğinde bildirim kanalı ile kullanıcıyı bilgilendir
    @Override
    public void update(String message) {
        channel.update(user, message);
    }

    // Abonelik iptali için
    public void unsubscribe() {
        website.removeObserver(this);
    }
}
