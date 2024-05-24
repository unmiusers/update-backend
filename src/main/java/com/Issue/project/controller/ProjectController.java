package com.Issue.project.controller;

import com.Issue.project.model.Project;
import com.Issue.project.service.ProjectService;

import java.util.List;

// ProjectController.java
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectRequest projectRequest, Authentication authentication) {
        Project project = projectService.createProject(projectRequest, authentication.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody ProjectRequest projectRequest) {
        Project project = projectService.updateProject(id, projectRequest);
        return ResponseEntity.ok(project);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id) {
        Project project = projectService.getProjectById(id);
        return ResponseEntity.ok(project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<Project>> getProjectsByUser(Authentication authentication) {
        List<Project> projects = projectService.getProjectsByUser(authentication.getName());
        return ResponseEntity.ok(projects);
    }
}