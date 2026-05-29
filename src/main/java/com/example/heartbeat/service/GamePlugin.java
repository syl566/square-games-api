package com.example.heartbeat.service;

import fr.le_campus_numerique.square_games.engine.Game;

import java.util.Locale;

public interface GamePlugin {

    String getGameId();

    String getName(Locale locale);

    Game createGame();

    Game createGame(int playerCount, int boardSize);
}
