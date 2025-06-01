package com.etatar.websitemonitoring.service;

import com.etatar.websitemonitoring.model.Subscription;
import com.etatar.websitemonitoring.model.User;
import com.etatar.websitemonitoring.model.Website;
import com.etatar.websitemonitoring.notification.Notification;
import java.util.List;

public class MonitorService {
    private List<User> users;

    public MonitorService(List<User> users) {
        this.users = users;
    }

    // Simulates the monitoring cycle for all users and subscriptions
    public void runMonitoringCycle() {
        for (User user : users) {
            for (Subscription subscription : user.getSubscriptions()) {
                Website site = subscription.getWebsite();
                if (site.hasChanged()) {
                    String message = "com.yourname.websitemonitoring.model.Website " + site.getUrl() + " has been updated!";
                    Notification notification = new Notification(message, subscription);
                    notification.deliver();
                }
            }
        }
    }
}
