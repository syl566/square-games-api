package com.example.heartbeat.controller;

import com.example.heartbeat.service.GamePlugin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class GameCatalogController {

    private final List<GamePlugin> plugins;

    public GameCatalogController(List<GamePlugin> plugins) {
        this.plugins = plugins;
    }

    @GetMapping("/games/catalog")
    public Collection<Map<String, String>> getGames(Locale locale) {

        Collection<Map<String, String>> games = new ArrayList<>();

        for (GamePlugin plugin : plugins) {

            Map<String, String> game = new HashMap<>();

            game.put("id", plugin.getGameId());

            game.put("name", plugin.getName(locale));

            games.add(game);
        }

        return games;
    }
}