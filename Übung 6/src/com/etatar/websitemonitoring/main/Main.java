package com.etatar.websitemonitoring.main;

import com.etatar.websitemonitoring.model.User;
import com.etatar.websitemonitoring.model.Website;
import com.etatar.websitemonitoring.notification.EmailChannel;
import com.etatar.websitemonitoring.notification.NotificationChannel;
import com.etatar.websitemonitoring.notification.PushNotificationChannel;
import com.etatar.websitemonitoring.notification.SMSChannel;
import com.etatar.websitemonitoring.service.MonitorService;
import com.etatar.websitemonitoring.strategy.ContentSizeComparisonStrategy;
import com.etatar.websitemonitoring.strategy.HtmlContentComparisonStrategy;
import com.etatar.websitemonitoring.strategy.TextContentComparisonStrategy;
import com.etatar.websitemonitoring.strategy.WebsiteComparisonStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Bildirim kanalları
        NotificationChannel emailChannel = new EmailChannel();
        NotificationChannel smsChannel = new SMSChannel();
        NotificationChannel pushChannel = new PushNotificationChannel();

        // Stratejiler
        WebsiteComparisonStrategy sizeStrategy = new ContentSizeComparisonStrategy();
        WebsiteComparisonStrategy htmlStrategy = new HtmlContentComparisonStrategy();
        WebsiteComparisonStrategy textStrategy = new TextContentComparisonStrategy();

        // Websiteler (her biri farklı strateji kullanıyor)
        Website site1 = new Website("https://example.com", sizeStrategy);
        Website site2 = new Website("https://openai.com", htmlStrategy);
        Website site3 = new Website("https://etatar.com", textStrategy);

        // Kullanıcılar
        User user1 = new User("Sana", "sana@example.com");
        User user2 = new User("Ali", "ali@example.com");

        // Abonelikler
        user1.subscribe("daily", emailChannel, site1);
        user1.subscribe("weekly", pushChannel, site2);
        user2.subscribe("hourly", smsChannel, site3);

        // Kullanıcı listesi
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        // Monitoring başlat
        MonitorService monitor = new MonitorService(users);

        System.out.println("==== Monitoring Başladı ====");
        monitor.runMonitoringCycle();  // burada içerik karşılaştırmaları yapılır
        System.out.println("==== Monitoring Bitti-übung6 ====");
    }
}
