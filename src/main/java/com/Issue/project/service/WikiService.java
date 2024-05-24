package com.Issue.project.service;

import com.Issue.project.model.WikiPage;

// WikiService.java
@Service
public class WikiService {

    @Autowired
    private WikiRepository wikiRepository;

    public WikiPage createPage(WikiRequest wikiRequest) {
        WikiPage page = new WikiPage();
        page.setTitle(wikiRequest.getTitle());
        page.setContent(wikiRequest.getContent());
        return wikiRepository.save(page);
    }

    public WikiPage getPageById(Long id) {
        return wikiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Wiki page not found"));
    }
}