package com.example.heartbeat.service;

import java.util.Collection;


public interface GameCatalog {
    Collection<String> getGameIds();
    Collection<String> getAvailableGames();

}

