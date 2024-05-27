package com.Issue.project.service;

import com.Issue.project.model.Plugin;
import com.Issue.project.repository.PluginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PluginService {

    @Autowired
    private PluginRepository pluginRepository;

    public List<Plugin> getAllPlugins() {
        return pluginRepository.findAll();
    }

    public Optional<Plugin> getPluginById(Long id) {
        return pluginRepository.findById(id);
    }

    public Plugin createPlugin(Plugin plugin) {
        return pluginRepository.save(plugin);
    }

    public Plugin updatePlugin(Long id, Plugin updatedPlugin) {
        return pluginRepository.findById(id).map(plugin -> {
            plugin.setName(updatedPlugin.getName());
            plugin.setVersion(updatedPlugin.getVersion());
            plugin.setDescription(updatedPlugin.getDescription());
            return pluginRepository.save(plugin);
        }).orElseThrow(() -> new ResourceNotFoundException("Plugin not found with id " + id));
    }

    public void deletePlugin(Long id) {
        pluginRepository.deleteById(id);
    }
}