package com.example.heartbeat.service;


import com.example.heartbeat.dto.GameCreationParams;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameStatus;
import fr.le_campus_numerique.square_games.engine.Token;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface GameService {

   Optional <Game> createGame(GameCreationParams params);
   Optional <Game> getGame (UUID gameID);
   Optional <GameStatus> getStatus(UUID gameID);

   Collection <Token> getAvailableTokens (UUID gameId);

   Optional <Game> playMove(UUID gameId, int x, int y);

}
