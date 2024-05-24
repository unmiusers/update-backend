package com.Issue.project.model;

// User.java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    // getters and setters
}

// Issue.java
@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    private User createdBy;
    // getters and setters
}

// Project.java
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    // getters and setters
}

// Notification.java
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private boolean read;
    @ManyToOne
    private User user;
    // getters and setters
}

// WikiPage.java
@Entity
public class WikiPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    // getters and setters
}

// Dashboard.java
public class Dashboard {
    private long openIssues;
    private List<Project> projects;
    // getters and setters
}

// Plugin.java
@Entity
public class Plugin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String version;
    // getters and setters
}

// AutomationTask.java
@Entity
public class AutomationTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private User createdBy;
    // getters and setters
}