package com.etatar.websitemonitoring.model;

import com.etatar.websitemonitoring.observer.Observer;
import com.etatar.websitemonitoring.observer.Subject;
import com.etatar.websitemonitoring.strategy.WebsiteComparisonStrategy;

import java.util.ArrayList;
import java.util.List;

public class Website implements Subject {
    private String url;
    private String lastContent;
    private List<Observer> observers;
    private WebsiteComparisonStrategy comparisonStrategy;

    public Website(String url, WebsiteComparisonStrategy strategy) {
        this.url = url;
        this.comparisonStrategy = strategy;
        this.lastContent = fetchWebsiteContent(); // Simüle edilmiş ilk içerik
        this.observers = new ArrayList<>();
    }

    public String getUrl() {
        return url;
    }

    public void setComparisonStrategy(WebsiteComparisonStrategy strategy) {
        this.comparisonStrategy = strategy;
    }

    // Subject interface implementasyonu
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    // Simüle edilmiş içerik çekme (gerçek uygulamada HTTP istekleri olurdu)
    private String fetchWebsiteContent() {
        return "<html><body>Content " + (int) (Math.random() * 1000) + "</body></html>";
    }

    // İçerik değişikliği kontrolü - Strategy Pattern kullanımı
    public void checkForUpdates() {
        String newContent = fetchWebsiteContent();
        if (comparisonStrategy != null && !comparisonStrategy.isContentSame(lastContent, newContent)) {
            lastContent = newContent;
            notifyObservers("Website " + url + " has been updated!");
        }
    }
}
