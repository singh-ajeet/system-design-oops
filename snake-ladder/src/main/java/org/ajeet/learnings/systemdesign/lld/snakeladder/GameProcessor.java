package org.ajeet.learnings.systemdesign.lld.snakeladder;

import org.ajeet.learnings.systemdesign.lld.snakeladder.model.Board;
import org.ajeet.learnings.systemdesign.lld.snakeladder.model.Move;
import org.ajeet.learnings.systemdesign.lld.snakeladder.user.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class GameProcessor {
    private final Queue<Player> playerQueue;
    private final Map<Player, Integer> playerPositions;
    private final Board board;
    private final Player[] winners;

    /**
     * Initially all players will be at 0 position (starting position, outside from board)
     *
     * @param players
     */
    public GameProcessor(List<Player> players, int boardSize, int numOfWinners) {
        this.playerQueue = new ArrayBlockingQueue<Player>(players.size());
        this.playerQueue.addAll(players);

        this.playerPositions = new HashMap<>(players.size());
        for (Player player : players){
            this.playerPositions.put(player, 0);
        }

        this.board = new Board(boardSize);
        winners = new Player[numOfWinners];
    }

    public Move move(int moves){
        Player currentPlayer = playerQueue.poll();
        int currentPosition = playerPositions.get(currentPlayer);

        if(!isValidMove(currentPlayer, moves)){
            return null;
        }

        int newPosition = currentPosition + moves;
        playerPositions.put(currentPlayer, newPosition);
        playerQueue.offer(currentPlayer);

        return new Move(moves, currentPlayer, currentPosition, newPosition);
    }

    private boolean isValidMove(Player player, int moves) {
        return playerPositions.get(player) + moves <= board.getSize();
    }
}
