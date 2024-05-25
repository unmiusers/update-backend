package com.Issue.project.service;

import com.Issue.project.model.AutomationTask;
import com.Issue.project.model.User;
import com.Issue.project.repository.AutomationRepository;
import com.Issue.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AutomationService {

    @Autowired
    private AutomationRepository automationRepository;

    @Autowired
    private UserRepository userRepository;

    public AutomationTask createAutomationTask(AutomationTask automationTask, String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        automationTask.setCreatedBy(user);
        automationTask.setCreatedDate(LocalDateTime.now());
        automationTask.setLastModifiedDate(LocalDateTime.now());
        return automationRepository.save(automationTask);
    }

    public AutomationTask updateAutomationTask(Long id, AutomationTask automationTask, String username) {
        AutomationTask existingTask = automationRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        existingTask.setName(automationTask.getName());
        existingTask.setDescription(automationTask.getDescription());
        existingTask.setStatus(automationTask.getStatus());
        existingTask.setLastModifiedDate(LocalDateTime.now());
        existingTask.setCreatedBy(user);
        return automationRepository.save(existingTask);
    }

    public AutomationTask getAutomationTaskById(Long id) {
        return automationRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteAutomationTask(Long id) {
        AutomationTask automationTask = automationRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        automationRepository.delete(automationTask);
    }

    public List<AutomationTask> getAutomationTasksByStatus(String status) {
        return automationRepository.findByStatus(status);
    }

    public List<AutomationTask> getAutomationTasksByUsername(String username) {
        return automationRepository.findByCreatedByUsername(username);
    }
}