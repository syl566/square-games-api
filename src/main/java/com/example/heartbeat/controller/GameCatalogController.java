package com.example.heartbeat.controller;

import com.example.heartbeat.service.GameCatalog;
import com.example.heartbeat.service.GamePlugin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

@RestController
public class GameCatalogController {

    private final List<GamePlugin> plugins;

    public GameCatalogController(List<GamePlugin> plugins) {
        this.plugins = plugins;
    }

    @GetMapping("/catalog")
    public Collection<String> getCatalog(Locale locale) {

        return plugins.stream()
                .map(plugin -> plugin.getName(locale))
                .toList();
    }
}