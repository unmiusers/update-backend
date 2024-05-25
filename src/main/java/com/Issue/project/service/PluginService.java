package com.Issue.project.service;

import com.Issue.project.controller.PluginController;
import org.springframework.beans.factory.annotation.Autowired;
import com.sun.source.util.Plugin;
import org.springframework.stereotype.Service;

// PluginService.java
@Service
public class PluginService {

    @Autowired
    private PluginRepository pluginRepository;

    public Plugin installPlugin(PluginRequest pluginRequest) {
        Plugin plugin = new Plugin();
        plugin.setName(pluginRequest.getName());
        plugin.setVersion(pluginRequest.getVersion());
        return pluginRepository.save(plugin);
    }
}