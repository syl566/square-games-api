package com.example.heartbeat.dao;

import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
@Primary
public class InMemoryGameDao implements GameDao {

    private final Map<String, Game> games = new HashMap<>();

    @Override
    public Stream<Game> findAll() {

        return games.values().stream();
    }

    @Override
    public Optional<Game> findById(UUID gameId) {

        return Optional.ofNullable(
                games.get(gameId.toString())
        );
    }

    @Override
    public Game upsert(Game game) {

        games.put(
                game.toString(),
                game
        );
        return game;
    }

    @Override
    public void delete(UUID gameId) {

        games.remove(gameId.toString());
    }
}