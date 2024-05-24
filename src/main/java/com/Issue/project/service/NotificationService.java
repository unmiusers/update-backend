package com.Issue.project.service;

import com.Issue.project.model.Notification;

import java.util.List;

// NotificationService.java
@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getNotificationsForUser(String username) {
        return notificationRepository.findByUsername(username);
    }
}