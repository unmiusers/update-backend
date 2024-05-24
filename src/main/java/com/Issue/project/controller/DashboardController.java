package com.Issue.project.controller;

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
