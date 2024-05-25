package com.Issue.project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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