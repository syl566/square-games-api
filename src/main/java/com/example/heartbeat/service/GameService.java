package com.example.heartbeat.service;

import fr.le_campus_numerique.square_games.engine.Game;
import java.util.UUID;

public interface GameService {

    void playMove(UUID gameId);

    UUID createGame(
            String gameType,
            int playerCount,
            int boardSize
    );

    Game getGame(UUID gameId);

}