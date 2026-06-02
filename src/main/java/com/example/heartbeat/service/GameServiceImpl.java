package com.example.heartbeat.service;

import com.example.heartbeat.dao.GameDao;
import com.example.heartbeat.dto.GameCreationParams;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameStatus;
import fr.le_campus_numerique.square_games.engine.Token;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    private final Map<String, GamePlugin> plugins;
    private final GameDao gameDao;

    public GameServiceImpl(
            List<GamePlugin> pluginsList,
            GameDao gameDao)
    {

        this.plugins = new HashMap<>();
        this.gameDao = gameDao;

        for (GamePlugin plugin : pluginsList) {
            plugins.put(
                    plugin.getGameId(),
                    plugin
            );
        }
    }

    @Override
    public Optional<Game> createGame(
            GameCreationParams params
    ) {

        GamePlugin plugin =
                plugins.get(params.getGameType());

        if (plugin == null) {
            return Optional.empty();
        }

        Game game = plugin.createGame(
                params.getPlayerCount(),
                params.getBoardSize()
        );

        gameDao.upsert(game);

        return Optional.of(game);
    }

    @Override
    public Optional<Game> getGame(
            UUID gameId
    ) {

        return gameDao.findById(gameId);
    }

    @Override
    public Optional<GameStatus> getStatus(
            UUID gameId
    ) {

        Optional<Game> gameOpt =
                gameDao.findById(
                        gameId
                );

        return gameOpt.map(Game::getStatus);

    }

    @Override
    public Collection<Token> getAvailableTokens(
            UUID gameId
    ) {

        Optional<Game> gameOpt =
                gameDao.findById(
                        gameId
                );

        if (gameOpt.isEmpty()) {
            return Collections.emptyList();
        }

        return gameOpt.get().getRemainingTokens();
    }

    @Override
    public Optional<Game> playMove(
            UUID gameId,
            int x,
            int y
    ) {

        Optional<Game> gameOpt =
                gameDao.findById(
                        gameId
                );

        if (gameOpt.isEmpty()) {
            return Optional.empty();
        }

        Game game = gameOpt.get();

        // À adapter selon l'API réelle du moteur
        // game.play(x, y);

        gameDao.upsert(game);

        return Optional.of(game);
    }
}