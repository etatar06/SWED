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
        // Kullanıcılar
        User user1 = new User("Sana", "sana@example.com");
        User user2 = new User("Ali", "ali@example.com");

        // Websiteler
        Website site1 = new Website("https://example.com");
        Website site2 = new Website("https://openai.com");

        // Bildirim kanalları
        NotificationChannel emailChannel = new EmailChannel();
        NotificationChannel smsChannel = new SMSChannel();
        NotificationChannel pushChannel = new PushNotificationChannel();

        // Kullanıcılar abonelik oluşturuyor (website'ye subscribe oluyorlar)
        user1.subscribe("daily", emailChannel, site1);
        user1.subscribe("weekly", pushChannel, site2);
        user2.subscribe("hourly", smsChannel, site2);

        // Kullanıcı listesi
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        // Monitoring servisi çalıştır
        MonitorService monitor = new MonitorService(users);

        System.out.println("---- Monitoring Started ----");
        monitor.runMonitoringCycle();
        System.out.println("---- Monitoring Ended ----");
    }
}
