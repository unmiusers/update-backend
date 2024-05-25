package com.Issue.project.repository;

import com.Issue.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Issue.project.model.User;

import java.util.Set;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    // Custom query methods
    int countOpenIssuesByUsername(String username);
    Set<Project> findProjectsByUsername(String username);
}
