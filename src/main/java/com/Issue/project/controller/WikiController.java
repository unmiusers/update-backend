package com.Issue.project.controller;

import com.Issue.project.model.Wikipage;
import com.Issue.project.service.WikipageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wiki")
public class WikiController {

    @Autowired
    private WikipageService wikipageService;

    @GetMapping
    public List<Wikipage> getAllPages() {
        return wikipageService.getAllPages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wikipage> getPageById(@PathVariable Long id) {
        return wikipageService.getPageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Wikipage createPage(@RequestBody Wikipage wikipage) {
        return wikipageService.createPage(wikipage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wikipage> updatePage(@PathVariable Long id, @RequestBody Wikipage updatedPage) {
        return ResponseEntity.ok(wikipageService.updatePage(id, updatedPage));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePage(@PathVariable Long id) {
        wikipageService.deletePage(id);
        return ResponseEntity.noContent().build();
    }
}