package com.example.heartbeat.dao;

import com.example.heartbeat.adapter.GameAdapter;
import com.example.heartbeat.entity.GameEntity;
import com.example.heartbeat.entity.GameEntityRepository;

import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;


@Repository
public class JpaGameDao implements GameDao {

    private final GameEntityRepository repository;
    private final GameAdapter adapter = new GameAdapter();

    public JpaGameDao(GameEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Game> findById(UUID gameId) {

        Optional<GameEntity> entity =
                repository.findById(gameId.toString());

        if (entity.isEmpty()) {
            return Optional.empty();
        }

        return Optional.empty(); // à compléter plus tard
    }

    @Override
    public Stream<Game> findAll() {
        return Stream.empty();
    }

    @Override
    public void delete(UUID gameId) {

    }

    @Override
    public Game upsert(Game game) {

        GameEntity entity = new GameEntity();

        entity.setId(game.getId().toString());

        repository.save(entity);
        return game;
    }
}