package com.Issue.project.service;

import com.Issue.project.model.Plugin;

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