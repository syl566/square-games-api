package com.example.heartbeat.service;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class TicTacToePlugin implements GamePlugin {

    @Value("${game.tictactoe.default-player-count}")
    private int playerCount;

    @Value("${game.tictactoe.default-board-size}")
    private int boardSize;

    private final TicTacToeGameFactory gameFactory =
            new TicTacToeGameFactory();

    private final MessageSource messageSource;

    public TicTacToePlugin(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public Game createGame() {
        return gameFactory.createGame(
                playerCount,
                boardSize
        );
    }

    @Override
    public Game createGame(
            int playerCount,
            int boardSize
    ) {
        return gameFactory.createGame(
                playerCount,
                boardSize
        );
    }

    @Override
    public String getName(Locale locale) {
        return messageSource.getMessage(
                "game.tictactoe.name",
                null,
                locale
        );
    }

    @Override
    public String getGameId() {
        return "tictactoe";
    }
}