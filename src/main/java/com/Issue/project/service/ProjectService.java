package com.Issue.project.service;

import com.Issue.project.dto.ProjectRequest;
import com.Issue.project.exception.ResourceNotFoundException;
import com.Issue.project.model.Project;
import com.Issue.project.model.User;
import com.Issue.project.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.docs.features.testing.springbootapplications.autoconfiguredspringdatajpa.withoutdb.UserRepository;
import java.util.List;

// ProjectService.java
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    public Project createProject(ProjectRequest projectRequest, String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Project project = new Project();
        project.setName(projectRequest.getName());
        project.setDescription(projectRequest.getDescription());
        project.setStatus("Active");
        project.setCreatedBy(user);
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, ProjectRequest projectRequest) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        project.setName(projectRequest.getName());
        project.setDescription(projectRequest.getDescription());
        project.setStatus(projectRequest.getStatus());
        return projectRepository.save(project);
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
    }

    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        projectRepository.delete(project);
    }

    public List<Project> getProjectsByUser(String username) {
        return projectRepository.findByCreatedByUsername(username);
    }
}