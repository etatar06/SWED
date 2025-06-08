package com.etatar.websitemonitoring.strategy;

public class HtmlContentComparisonStrategy implements WebsiteComparisonStrategy {
    @Override
    public boolean isContentSame(String oldContent, String newContent) {
        return oldContent.equals(newContent);
    }
}

