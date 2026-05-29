package com.example.heartbeat.service;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class TaquinPlugin implements GamePlugin {

    private final MessageSource messageSource;
    @Value("${game.taquin.default-player-count}")
    private int playerCount;

    @Value("${game.taquin.default-board-size}")
    private int boardSize;

    public TaquinPlugin(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public Game createGame(){return new TaquinGameFactory().createGame(playerCount, boardSize);}

    @Override
    public Game createGame(int playerCount, int boardSize) {
        return null;
    }

    public String getName(Locale locale){
        return messageSource.getMessage("game.taquin.name",null, locale);
    }
    public String getGameId(){
        return "taquin";}

    }

