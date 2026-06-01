package com.example.heartbeat.service;

import com.example.heartbeat.dto.GameCreationParams;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameStatus;
import fr.le_campus_numerique.square_games.engine.Token;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    private final Map<String, GamePlugin> plugins;
    private final Map<UUID, Game> games = new HashMap<>();

    public GameServiceImpl(List<GamePlugin> pluginsList) {

        this.plugins = new HashMap<>();

        for (GamePlugin plugin : pluginsList) {
            plugins.put(plugin.getGameId(), plugin);
        }
    }

    @Override
    public Optional<Game> createGame(GameCreationParams params) {

        GamePlugin plugin = plugins.get(params.getGameType());

        if (plugin == null) {
            return Optional.empty();
        }

        Game game = plugin.createGame(
                params.getPlayerCount(),
                params.getBoardSize()
        );

        UUID gameId = UUID.randomUUID();

        games.put(gameId, game);

        return Optional.of(game);
    }

    @Override
    public Optional<Game> getGame(UUID gameId) {

        return Optional.ofNullable(
                games.get(gameId)
        );
    }

    @Override
    public Optional<GameStatus> getStatus(UUID gameId) {

        Game game = games.get(gameId);

        if (game == null) {
            return Optional.empty();
        }

        return Optional.of(game.getStatus());
    }

    @Override
    public Collection<Token> getAvailableTokens(UUID gameId) {

        Game game = games.get(gameId);

        if (game == null) {
            return Collections.emptyList();
        }

        return game.getRemainingTokens();
    }

    @Override
    public Optional<Game> playMove(UUID gameId, int x, int y) {

        Game game = games.get(gameId);

        if (game == null) {
            return Optional.empty();
        }

        // À adapter selon le moteur
        game.getPlayerIds();

        return Optional.of(game);
    }
}