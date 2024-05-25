package com.Issue.project.repository;

import com.Issue.project.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByAssignedUserId(Long userId);
    List<Issue> findByProjectId(Long projectId);
}
