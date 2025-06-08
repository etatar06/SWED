package com.etatar.websitemonitoring.service;

import com.etatar.websitemonitoring.model.User;
import com.etatar.websitemonitoring.model.Subscription;
import com.etatar.websitemonitoring.model.Website;

import java.util.List;

public class MonitorService {
    private List<User> users;

    public MonitorService(List<User> users) {
        this.users = users;
    }

    public void runMonitoringCycle() {
        for (User user : users) {
            for (Subscription subscription : user.getSubscriptions()) {
                Website site = subscription.getWebsite();
                site.checkForUpdates();  // Website değişikliği kontrol ediyor, observerlara haber veriyor
            }
        }
    }
}
