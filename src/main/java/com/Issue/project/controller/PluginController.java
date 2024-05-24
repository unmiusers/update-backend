package com.Issue.project.controller;

import com.Issue.project.service.PluginService;

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