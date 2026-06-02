package com.example.heartbeat.adapter;

import com.example.heartbeat.entity.GameEntity;
import fr.le_campus_numerique.square_games.engine.Game;

public class GameAdapter {

    public GameEntity toEntity(String gameId, Game game) {

        GameEntity entity = new GameEntity();

        entity.setId(gameId);
        entity.setFactoryId("tictactoe");
        entity.setBoardSize(game.getBoardSize());

        return entity;
    }
}