package com.example.heartbeat.entity;

import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import java.util.List;

@Entity
public class GameEntity {

    public GameEntity(){}

    @Id
    private String id;

    @Column(name = "factory_id")
    private String factoryId;

    @Column(name = "board_size")
    private int boardSize;

    @Column(name = "player_ids")
    private String playerIds;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "game_id")
    private List<GameTokenEntity> tokens;

    // getters

    public String getId() {
        return id;
    }

    public String getPlayerIds() {
        return playerIds;
    }

    public List<GameTokenEntity> getTokens() {
        return tokens;
    }
    //setter
    public void setId(String id) {
        this.id = id;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public void setPlayerIds(String playerIds) {
        this.playerIds = playerIds;
    }

    public void setTokens(List<GameTokenEntity> tokens) {
        this.tokens = tokens;
    }
}