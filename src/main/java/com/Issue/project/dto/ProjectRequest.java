package com.Issue.project.dto;

public class ProjectRequest {

    private String name;
    private String description;
    private String owner;

    // Constructors
    public ProjectRequest() {}

    public ProjectRequest(String name, String description, String owner) {
        this.name = name;
        this.description = description;
        this.owner = owner;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
