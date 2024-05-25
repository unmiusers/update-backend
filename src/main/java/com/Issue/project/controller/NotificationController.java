package com.Issue.project.controller;

import com.Issue.project.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import javax.management.Notification;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;

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