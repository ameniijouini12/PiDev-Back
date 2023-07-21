package com.example.pidevge.interfaces;

import com.example.pidevge.Entities.Notification;
import com.example.pidevge.Entities.User;

import java.util.List;

public interface NotificationService {

    void sendNotification(User user, String content);
    List<Notification> getAllNotificationsForUser(User user);
}
