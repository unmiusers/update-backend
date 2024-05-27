package com.Issue.project.repository;

import com.Issue.project.model.Wikipage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikipageRepository extends JpaRepository<Wikipage, Long> {
}