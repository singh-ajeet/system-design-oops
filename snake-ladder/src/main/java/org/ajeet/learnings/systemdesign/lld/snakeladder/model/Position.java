package org.ajeet.learnings.systemdesign.lld.snakeladder.model;

import org.ajeet.learnings.systemdesign.lld.snakeladder.user.Player;

public class Position {
    private final int cellNumber;
    private final Player player;

    public Position(int cellNumber, Player player) {
        this.cellNumber = cellNumber;
        this.player = player;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public Player getPlayer() {
        return player;
    }
}
