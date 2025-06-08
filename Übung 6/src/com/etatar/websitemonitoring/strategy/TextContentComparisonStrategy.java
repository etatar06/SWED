package com.etatar.websitemonitoring.strategy;

public class TextContentComparisonStrategy implements WebsiteComparisonStrategy {
    @Override
    public boolean isContentSame(String oldContent, String newContent) {
        String oldText = oldContent.replaceAll("<[^>]*>", "").trim();
        String newText = newContent.replaceAll("<[^>]*>", "").trim();
        return oldText.equals(newText);
    }
}

