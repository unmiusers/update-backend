package com.Issue.project.service;

import com.Issue.project.model.Issue;
import com.Issue.project.model.User;

// IssueService.java
@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private UserRepository userRepository;

    public Issue createIssue(IssueRequest issueRequest, String username) {
        User user = userRepository.findByUsername(username);
        Issue issue = new Issue();
        issue.setTitle(issueRequest.getTitle());
        issue.setDescription(issueRequest.getDescription());
        issue.setCreatedBy(user);
        return issueRepository.save(issue);
    }

    public Issue getIssueById(Long id) {
        return issueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Issue not found"));
    }
}