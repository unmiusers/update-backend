package com.Issue.project.controller;

import com.Issue.project.model.WikiPage;
import com.Issue.project.service.WikiService;

// WikiController.java
@RestController
@RequestMapping("/api/wiki")
public class WikiController {

    @Autowired
    private WikiService wikiService;

    @PostMapping
    public ResponseEntity<WikiPage> createPage(@RequestBody WikiRequest wikiRequest) {
        WikiPage page = wikiService.createPage(wikiRequest);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WikiPage> getPage(@PathVariable Long id) {
        WikiPage page = wikiService.getPageById(id);
        return ResponseEntity.ok(page);
    }
}
