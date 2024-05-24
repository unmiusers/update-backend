package com.Issue.project.service;

import com.Issue.project.model.Issue;

// VersionIntegrationService.java
@Service
public class VersionIntegrationService {

    @Autowired
    private IssueRepository issueRepository;

    public void integrateVersionControl(String commitMessage, Long issueId) {
        Issue issue = issueRepository.findById(issueId).orElseThrow(() -> new ResourceNotFoundException("Issue not found"));
        // Logic to integrate version control (e.g., update issue status)
    }
}