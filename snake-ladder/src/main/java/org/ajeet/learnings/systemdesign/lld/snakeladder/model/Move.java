package org.ajeet.learnings.systemdesign.lld.snakeladder.model;

import org.ajeet.learnings.systemdesign.lld.snakeladder.user.Player;

public class Move {
    private final int numOfMoves;
    private final Player player;

    private final int oldPosition;
    private final int newPosition;

    public Move(int numOfMoves, Player player, int oldPosition, int newPosition) {
        this.numOfMoves = numOfMoves;
        this.player = player;
        this.oldPosition = oldPosition;
        this.newPosition = newPosition;
    }

    public int getNumOfMoves() {
        return numOfMoves;
    }

    public Player getPlayer() {
        return player;
    }

    public int getOldPosition() {
        return oldPosition;
    }

    public int getNewPosition() {
        return newPosition;
    }
}
