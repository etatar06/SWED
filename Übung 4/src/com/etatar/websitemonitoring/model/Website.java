package com.etatar.websitemonitoring.model;

public class Website {
    private String url;
    private String lastChecked;
    private int lastContentHash;

    public Website(String url) {
        this.url = url;
        this.lastChecked = "";
        this.lastContentHash = (int) (Math.random() * 10000); // Simulated hash
    }

    public String getUrl() {
        return url;
    }

    // Simulates checking if content has changed
    public boolean hasChanged() {
        int newHash = (int) (Math.random() * 10000);
        boolean changed = newHash != lastContentHash;
        lastContentHash = newHash;
        return changed;
    }
}
