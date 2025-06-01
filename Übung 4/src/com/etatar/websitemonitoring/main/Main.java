package com.etatar.websitemonitoring.main;

import com.etatar.websitemonitoring.model.User;
import com.etatar.websitemonitoring.model.Website;
import com.etatar.websitemonitoring.notification.EmailChannel;
import com.etatar.websitemonitoring.notification.NotificationChannel;
import com.etatar.websitemonitoring.notification.SMSChannel;
import com.etatar.websitemonitoring.notification.PushNotificationChannel;
import com.etatar.websitemonitoring.service.MonitorService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Create users
        User user1 = new User("Sana", "sana@example.com");
        User user2 = new User("Ali", "ali@example.com");

        // Create websites
        Website site1 = new Website("https://example.com");
        Website site2 = new Website("https://openai.com");

        // Create notification channels
        NotificationChannel emailChannel = new EmailChannel();
        NotificationChannel smsChannel = new SMSChannel();
        NotificationChannel pushChannel = new PushNotificationChannel();

        // Users subscribe to websites
        user1.subscribe("daily", emailChannel, site1);
        user1.subscribe("weekly", pushChannel, site2);
        user2.subscribe("hourly", smsChannel, site2);

        // Add users to a list
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        // Start monitoring service and run a monitoring cycle
        MonitorService monitor = new MonitorService(users);

        System.out.println("---- Monitoring Started ----");
        monitor.runMonitoringCycle();
        System.out.println("---- Monitoring Ended ----");
    }
}
