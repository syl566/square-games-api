package com.example.heartbeat.service;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class TicTacToePlugin implements GamePlugin {
    @Value("${game.tictactoe.default-player-count}")
    private int PlayerCount;

    @Value("${game.tictactoe.default-board-size}")
    private int BoardSize;
    private final TaquinGameFactory ticTacToeGameFactory = new TaquinGameFactory();


    public Game createGame() {
        return ticTacToeGameFactory.createGame(PlayerCount,BoardSize);
    }

    @Override
    public Game createGame(int playerCount, int boardSize) {
        return null;
    }

    public String getName(Locale locale) {
        return messageSource.getMessage(
                "game.tictactoe.name",
                null,
                locale
        );
    }

    public String getGameId() {
        return "tictactoe";

    }
    @Autowired
        private MessageSource messageSource;
    }
