package com.example.heartbeat.controller;

import com.example.heartbeat.dto.GameCreationParams;
import com.example.heartbeat.service.GameService;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // CREATE GAME
    @PostMapping("/games")
    public UUID createGame(@RequestBody GameCreationParams params) {

        return gameService.createGame(
                params.getGameType(),
                params.getPlayerCount(),
                params.getBoardSize()
        );
    }

    // GET GAME BY ID
    @GetMapping("/games/{gameId}")
    public Game getGame(@PathVariable UUID gameId) {

        return gameService.getGame(gameId);
    }

    // GET ALL GAMES
    /*@GetMapping("/games")
    public Collection<UUID> getGames() {

        return gameService.getGames();
    }*/

    // PLAY / UPDATE GAME
    @PutMapping("/games/{gameId}")
    public void playMove(@PathVariable UUID gameId) {

        gameService.playMove(gameId);
    }
}