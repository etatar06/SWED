package com.etatar.websitemonitoring.model;

import com.etatar.websitemonitoring.observer.Observer;
import com.etatar.websitemonitoring.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class Website implements Subject {
    private String url;
    private String lastChecked;
    private int lastContentHash;
    private List<Observer> observers;

    public Website(String url) {
        this.url = url;
        this.lastChecked = "";
        this.lastContentHash = (int) (Math.random() * 10000);
        this.observers = new ArrayList<>();
    }

    public String getUrl() {
        return url;
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

    // İçerik değişikliği kontrolü ve notify tetikleme
    public void checkForUpdates() {
        int newHash = (int) (Math.random() * 10000);
        if (newHash != lastContentHash) {
            lastContentHash = newHash;
            notifyObservers("Website " + url + " has been updated!");
        }
    }
}
