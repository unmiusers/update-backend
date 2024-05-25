package com.Issue.project.controller;

import com.Issue.project.model.AutomationTask;
import com.Issue.project.service.AutomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@RestController
@RequestMapping("/api/automation")
public class AutomationController {

    @Autowired
    private AutomationService automationService;

    @PostMapping("/tasks")
    public ResponseEntity<AutomationTask> createAutomationTask(@RequestBody AutomationTask automationTask, Authentication authentication) {
        String username = authentication.getName();
        AutomationTask createdTask = automationService.createAutomationTask(automationTask, username);
        return ResponseEntity.ok(createdTask);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<AutomationTask> updateAutomationTask(@PathVariable Long id, @RequestBody AutomationTask automationTask, Authentication authentication) {
        String username = authentication.getName();
        AutomationTask updatedTask = automationService.updateAutomationTask(id, automationTask, username);
        return ResponseEntity.ok(updatedTask);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<AutomationTask> getAutomationTaskById(@PathVariable Long id) {
        AutomationTask automationTask = automationService.getAutomationTaskById(id);
        return ResponseEntity.ok(automationTask);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteAutomationTask(@PathVariable Long id) {
        automationService.deleteAutomationTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tasks/status")
    public ResponseEntity<List<AutomationTask>> getAutomationTasksByStatus(@RequestParam String status) {
        List<AutomationTask> tasks = automationService.getAutomationTasksByStatus(status);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/tasks/user")
    public ResponseEntity<List<AutomationTask>> getAutomationTasksByUsername(Authentication authentication) {
        String username = authentication.getName();
        List<AutomationTask> tasks = automationService.getAutomationTasksByUsername(username);
        return ResponseEntity.ok(tasks);
    }
}