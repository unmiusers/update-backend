package com.Issue.project.controller;

import com.Issue.project.service.PluginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import com.sun.source.util.Plugin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


// PluginController.java
@RestController
@RequestMapping("/api/plugins")
public class PluginController {

    @Autowired
    private PluginService pluginService;

    @PostMapping
    public ResponseEntity<Plugin> installPlugin(@RequestBody PluginRequest pluginRequest) {
        Plugin plugin = pluginService.installPlugin(pluginRequest);
        return ResponseEntity.ok(plugin);
    }
}