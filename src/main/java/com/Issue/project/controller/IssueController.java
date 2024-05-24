package com.Issue.project.controller;

import com.Issue.project.model.Issue;
import com.Issue.project.service.IssueService;

// IssueController.java
@RestController
@RequestMapping("/api/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @PostMapping
    public ResponseEntity<Issue> createIssue(@RequestBody IssueRequest issueRequest, Authentication authentication) {
        Issue issue = issueService.createIssue(issueRequest, authentication.getName());
        return ResponseEntity.ok(issue);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Issue> getIssue(@PathVariable Long id) {
        Issue issue = issueService.getIssueById(id);
        return ResponseEntity.ok(issue);
    }
}
