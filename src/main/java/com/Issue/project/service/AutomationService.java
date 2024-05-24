package com.Issue.project.service;

import com.Issue.project.model.AutomationTask;

// AutomationService.java
@Service
public class AutomationService {

    @Autowired
    private AutomationRepository automationRepository;

    public AutomationTask createTask(AutomationTaskRequest taskRequest, String username) {
        AutomationTask task = new AutomationTask();
        task.setName(taskRequest.getName());
        task.setDescription(taskRequest.getDescription());
        task.setCreatedBy(username);
        // Additional task configuration logic
        return automationRepository.save(task);
    }

    public AutomationTask getTaskById(Long id) {
        return automationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }
}