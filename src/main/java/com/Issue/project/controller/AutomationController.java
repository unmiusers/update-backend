package com.Issue.project.controller;

import com.Issue.project.model.AutomationTask;

// AutomationController.java
@RestController
    @RequestMapping("/api/automation")
    public class AutomationController {

        @Autowired
        private AutomationService automationService;

        @PostMapping("/tasks")
        public ResponseEntity<AutomationTask> createTask(@RequestBody AutomationTaskRequest taskRequest, Authentication authentication) {
            AutomationTask task = automationService.createTask(taskRequest, authentication.getName());
            return ResponseEntity.ok(task);
        }

        @GetMapping("/tasks/{id}")
        public ResponseEntity<AutomationTask> getTask(@PathVariable Long id) {
            AutomationTask task = automationService.getTaskById(id);
            return ResponseEntity.ok(task);
        }
    }
