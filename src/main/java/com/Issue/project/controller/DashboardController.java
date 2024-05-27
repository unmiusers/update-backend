package com.Issue.project.controller;

import com.Issue.project.model.Dashboard;
import com.Issue.project.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.ResponseEntity;

// DashboardController.java
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<Dashboard> getDashboard(Authentication authentication) {
        Dashboard dashboard = dashboardService.getDashboardForUser(authentication.getName());
        return ResponseEntity.ok(dashboard);
    }
}
