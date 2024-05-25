package com.Issue.project.repository;

import com.Issue.project.model.Project;
import org.springframework.stereotype.Repository;
import java.util.List;

// ProjectRepository.java
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByCreatedByUsername(String username);
}