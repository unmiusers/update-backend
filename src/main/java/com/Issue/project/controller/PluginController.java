package com.Issue.project.controller;

import com.Issue.project.dto.PluginRequest;
import com.Issue.project.model.Plugin;
import com.Issue.project.service.PluginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plugins")
public class PluginController {

    @Autowired
    private PluginService pluginService;

    @GetMapping
    public List<Plugin> getAllPlugins() {
        return pluginService.getAllPlugins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plugin> getPluginById(@PathVariable Long id) {
        return pluginService.getPluginById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Plugin createPlugin(@RequestBody PluginRequest pluginRequest) {
        Plugin plugin = new Plugin();
        plugin.setName(pluginRequest.getName());
        plugin.setVersion(pluginRequest.getVersion());
        plugin.setDescription(pluginRequest.getDescription());
        return pluginService.createPlugin(plugin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plugin> updatePlugin(@PathVariable Long id, @RequestBody PluginRequest pluginRequest) {
        Plugin updatedPlugin = new Plugin();
        updatedPlugin.setName(pluginRequest.getName());
        updatedPlugin.setVersion(pluginRequest.getVersion());
        updatedPlugin.setDescription(pluginRequest.getDescription());
        return ResponseEntity.ok(pluginService.updatePlugin(id, updatedPlugin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlugin(@PathVariable Long id) {
        pluginService.deletePlugin(id);
        return ResponseEntity.noContent().build();
    }
}