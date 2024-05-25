package com.Issue.project.repository;

import com.Issue.project.model.AutomationTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomationRepository extends JpaRepository<AutomationTask, Long> {
    List<AutomationTask> findByStatus(String status);
    List<AutomationTask> findByCreatedByUsername(String username);
}