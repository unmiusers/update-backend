package com.Issue.project.controller;

import com.Issue.project.service.NotificationService;

// NotificationController.java
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<Notification>> getNotifications(Authentication authentication) {
        List<Notification> notifications = notificationService.getNotificationsForUser(authentication.getName());
        return ResponseEntity.ok(notifications);
    }
}