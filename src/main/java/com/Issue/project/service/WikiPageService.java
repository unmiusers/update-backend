package com.Issue.project.service;

import com.Issue.project.model.Wikipage;
import com.Issue.project.repository.WikipageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WikipageService {

    @Autowired
    private WikipageRepository wikipageRepository;

    public List<Wikipage> getAllPages() {
        return wikipageRepository.findAll();
    }

    public Optional<Wikipage> getPageById(Long id) {
        return wikipageRepository.findById(id);
    }

    public Wikipage createPage(Wikipage wikipage) {
        return wikipageRepository.save(wikipage);
    }

    public Wikipage updatePage(Long id, Wikipage updatedPage) {
        return wikipageRepository.findById(id).map(page -> {
            page.setTitle(updatedPage.getTitle());
            page.setContent(updatedPage.getContent());
            page.setAuthor(updatedPage.getAuthor());
            return wikipageRepository.save(page);
        }).orElseThrow(() -> new ResourceNotFoundException("Page not found with id " + id));
    }

    public void deletePage(Long id) {
        wikipageRepository.deleteById(id);
    }
}