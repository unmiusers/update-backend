package com.Issue.project.service;

import com.Issue.project.model.Issue;
import com.Issue.project.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    public List<Issue> getIssuesByUserId(Long userId) {
        return issueRepository.findByAssignedUserId(userId);
    }

    public List<Issue> getIssuesByProjectId(Long projectId) {
        return issueRepository.findByProjectId(projectId);
    }

    public Issue createIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    public Issue updateIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    public void deleteIssue(Long issueId) {
        issueRepository.deleteById(issueId);
    }
}