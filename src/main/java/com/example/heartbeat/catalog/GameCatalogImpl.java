package com.example.heartbeat.catalog;

import com.example.heartbeat.service.GameCatalog;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class GameCatalogImpl implements GameCatalog {

    @Override
    public Collection<String> getGameIds() {

        return List.of("tictactoe");
    }

    @Override
    public Collection<String> getAvailableGames() {
        return List.of();
    }
}
