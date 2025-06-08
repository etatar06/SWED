package com.etatar.websitemonitoring.notification;

import com.etatar.websitemonitoring.model.User;

public interface NotificationChannel {
    void update(User user, String message);
}
