package src.Game.src.main.java.org.example.Models;

import src.Game.src.main.java.org.example.Utils.GameLogger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerTurn {
    private List<Player> players;
    private int currentPlayerIndex = 0;
    private List<Player> losers;

    public PlayerTurn(List<Player> players) {
        this.players = players;
        this.losers = new ArrayList<>();
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void nextTurn() {
        currentPlayerIndex++;
        if (currentPlayerIndex >= players.size()) {
            currentPlayerIndex = 0;
        }
    }

    public void update() {
        List<Player> toRemove = new ArrayList<>();
        Player current = getCurrentPlayer();

        for (Player player : players) {
            if (player.isDefeated()) {
                toRemove.add(player);
            }
        }

        for (Player defeated : toRemove) {
            int removedIndex = players.indexOf(defeated);
            players.remove(defeated);
            losers.add(defeated);

            if (removedIndex < currentPlayerIndex) {
                currentPlayerIndex--;
            } else if (removedIndex == currentPlayerIndex) {
                if (currentPlayerIndex >= players.size()) {
                    currentPlayerIndex = 0;
                }
            }

            GameLogger.log("Player " + defeated.getPlayerNumber() + " has been removed.");
        }

        if (players.isEmpty()) {
            currentPlayerIndex = 0;
        }
    }

    public List<Player> getLosers() {
        return losers;
    }

    public Player Loser() {
        if (losers.isEmpty()) {
            GameLogger.log("Tried to get last loser but the list was empty.");
            return null;
        }
        return losers.get(losers.size() - 1);
    }

    public void removeLoser(Player player) {
        if (!losers.contains(player)) {
            GameLogger.log("Tried to remove non-existent loser: Player " + player.getPlayerNumber());
            return;
        }
        losers.remove(player);
    }
    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }
}

