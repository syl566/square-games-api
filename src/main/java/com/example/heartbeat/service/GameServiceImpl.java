package com.example.heartbeat.service;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    private final TicTacToeGameFactory gameFactory;

    private final Map<UUID, Game> games = new HashMap<>();

   // Constructeur
   public GameServiceImpl(TicTacToeGameFactory gameFactory) {
       this.gameFactory = gameFactory;
   }

    @Override
    public UUID createGame(
            String gameType,
            int playerCount,
            int boardSize
    ) {

        Game game = gameFactory.createGame(
                playerCount,
                boardSize
        );

        UUID gameId = UUID.randomUUID();

        games.put(gameId, game);

        return gameId;
    }

    @Override
    public Game getGame(UUID gameId) {

        return games.get(gameId);
    }

    @Override
    public void playMove(UUID gameId) {

        Game game = games.get(gameId);


    }}