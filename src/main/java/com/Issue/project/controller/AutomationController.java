package com.Issue.project.controller;

import com.Issue.project.model.AutomationTask;
import com.Issue.project.service.AutomationService;

import java.util.List;

// AutomationController.java
@RestController
@RequestMapping("/api/automation")
public class AutomationController {

    @Autowired
    private AutomationService automationService;

    @PostMapping("/tasks")
    public ResponseEntity<AutomationTask> createTask(@RequestBody AutomationTaskRequest taskRequest, Authentication authentication) {
        AutomationTask task = automationService.createTask(taskRequest, authentication.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<AutomationTask> updateTask(@PathVariable Long id, @RequestBody AutomationTaskRequest taskRequest) {
        AutomationTask task = automationService.updateTask(id, taskRequest);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<AutomationTask> getTask(@PathVariable Long id) {
        AutomationTask task = automationService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        automationService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tasks/user")
    public ResponseEntity<List<AutomationTask>> getTasksByUser(Authentication authentication) {
        List<AutomationTask> tasks = automationService.getTasksByUser(authentication.getName());
        return ResponseEntity.ok(tasks);
    }
}