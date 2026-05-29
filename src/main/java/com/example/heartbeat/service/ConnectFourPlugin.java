package com.example.heartbeat.service;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.util.Locale;

@Component
public class ConnectFourPlugin implements GamePlugin {

    private final ConnectFourGameFactory factory;

    @Value("${game.connectfour.default-player-count}")
    private int defaultPlayerCount;

    @Value("${game.connectfour.default-board-size}")
    private int defaultBoardSize;

    public ConnectFourPlugin(ConnectFourGameFactory factory) {
        this.factory = factory;
    }

    @Override
    public String getGameId() {
        return "connectfour";
    }

    @Override
    public String getName(Locale locale) {
        return "game.connectfour.name";
    }

    @Override
    public Game createGame() {

        return factory.createGame(
                defaultPlayerCount,
                defaultBoardSize
        );
    }

    @Override
    public Game createGame(int playerCount, int boardSize) {

        return factory.createGame(
                playerCount,
                boardSize
        );
    }
}