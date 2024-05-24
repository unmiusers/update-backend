package com.Issue.project.service;

import com.Issue.project.model.User;
import com.Issue.project.model.WikiPage;

import java.time.LocalDateTime;
import java.util.List;

// WikiPageService.java
@Service
public class WikiPageService {

    @Autowired
    private WikiPageRepository wikiPageRepository;

    @Autowired
    private UserRepository userRepository;

    public WikiPage createWikiPage(WikiPageRequest wikiPageRequest, String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        WikiPage wikiPage = new WikiPage();
        wikiPage.setTitle(wikiPageRequest.getTitle());
        wikiPage.setContent(wikiPageRequest.getContent());
        wikiPage.setCreatedDate(LocalDateTime.now());
        wikiPage.setLastModifiedDate(LocalDateTime.now());
        wikiPage.setCreatedBy(user);
        wikiPage.setLastModifiedBy(user);
        return wikiPageRepository.save(wikiPage);
    }

    public WikiPage updateWikiPage(Long id, WikiPageRequest wikiPageRequest, String username) {
        WikiPage wikiPage = wikiPageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Wiki page not found"));
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        wikiPage.setTitle(wikiPageRequest.getTitle());
        wikiPage.setContent(wikiPageRequest.getContent());
        wikiPage.setLastModifiedDate(LocalDateTime.now());
        wikiPage.setLastModifiedBy(user);
        return wikiPageRepository.save(wikiPage);
    }

    public WikiPage getWikiPageById(Long id) {
        return wikiPageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Wiki page not found"));
    }

    public void deleteWikiPage(Long id) {
        WikiPage wikiPage = wikiPageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Wiki page not found"));
        wikiPageRepository.delete(wikiPage);
    }

    public List<WikiPage> searchWikiPages(String title) {
        return wikiPageRepository.findByTitleContaining(title);
    }
}
