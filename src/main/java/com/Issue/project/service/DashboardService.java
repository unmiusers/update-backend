package com.Issue.project.service;

import com.Issue.project.model.Dashboard;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.Issue.project.repository.ProjectRepository;

// DashboardService.java
@Service
public class DashboardService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public Dashboard getDashboardForUser(String username) {
        Dashboard dashboard = new Dashboard();
        dashboard.setOpenIssues(issueRepository.countOpenIssuesByUsername(username));
        dashboard.setProjects(projectRepository.findProjectsByUsername(username));
        return dashboard;
    }
}