package com.etatar.websitemonitoring.strategy;

public class ContentSizeComparisonStrategy implements WebsiteComparisonStrategy {
    @Override
    public boolean isContentSame(String oldContent, String newContent) {
        return oldContent.length() == newContent.length();
    }
}

