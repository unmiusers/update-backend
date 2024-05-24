package com.Issue.project.repository;

import com.Issue.project.model.Project;

// ProjectRepository.java
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByCreatedByUsername(String username);
}