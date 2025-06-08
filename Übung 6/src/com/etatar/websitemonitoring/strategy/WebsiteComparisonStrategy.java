package com.etatar.websitemonitoring.strategy;

public interface WebsiteComparisonStrategy {
    boolean isContentSame(String oldContent, String newContent);
}

