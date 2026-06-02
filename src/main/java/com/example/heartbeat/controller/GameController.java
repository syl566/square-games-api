package com.example.heartbeat.controller;

import com.example.heartbeat.dto.GameCreationParams;
import com.example.heartbeat.service.GameService;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // CREATE GAME
    @PostMapping("/games")
    public Optional<Game> createGame(
            @RequestBody GameCreationParams params
    ) {

        return gameService.createGame(params);
    }

    // GET GAME BY ID
    @GetMapping("/games/{gameId}")
    public Optional<Game> getGame(
            @PathVariable UUID gameId
    ) {

        return gameService.getGame(gameId);
    }

    @PutMapping("/games/{gameId}")
    public Optional<Game> playMove(
            @PathVariable UUID gameId,
            @RequestParam int x,
            @RequestParam int y
    ) {

        return gameService.playMove(
                gameId,
                x,
                y
        );
    }
}




