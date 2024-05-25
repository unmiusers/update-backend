package com.Issue.project.controller;

import com.Issue.project.service.WikiPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;

// WikiPageController.java
@RestController
@RequestMapping("/api/wiki")
public class WikiPageController {

    @Autowired
    private WikiPageService wikiPageService;

    @PostMapping("/pages")
    public ResponseEntity<WikiPage> createWikiPage(@RequestBody WikiPageRequest wikiPageRequest, Authentication authentication) {
        WikiPage wikiPage = wikiPageService.createWikiPage(wikiPageRequest, authentication.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(wikiPage);
    }

    @PutMapping("/pages/{id}")
    public ResponseEntity<WikiPage> updateWikiPage(@PathVariable Long id, @RequestBody WikiPageRequest wikiPageRequest, Authentication authentication) {
        WikiPage wikiPage = wikiPageService.updateWikiPage(id, wikiPageRequest, authentication.getName());
        return ResponseEntity.ok(wikiPage);
    }

    @GetMapping("/pages/{id}")
    public ResponseEntity<WikiPage> getWikiPage(@PathVariable Long id) {
        WikiPage wikiPage = wikiPageService.getWikiPageById(id);
        return ResponseEntity.ok(wikiPage);
    }

    @DeleteMapping("/pages/{id}")
    public ResponseEntity<Void> deleteWikiPage(@PathVariable Long id) {
        wikiPageService.deleteWikiPage(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pages/search")
    public ResponseEntity<List<WikiPage>> searchWikiPages(@RequestParam String title) {
        List<WikiPage> wikiPages = wikiPageService.searchWikiPages(title);
        return ResponseEntity.ok(wikiPages);
    }
}