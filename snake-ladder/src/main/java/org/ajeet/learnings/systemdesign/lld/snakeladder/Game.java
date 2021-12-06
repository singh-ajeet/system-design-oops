package org.ajeet.learnings.systemdesign.lld.snakeladder;

import org.ajeet.learnings.systemdesign.lld.snakeladder.model.DefaultDice;
import org.ajeet.learnings.systemdesign.lld.snakeladder.model.Move;
import org.ajeet.learnings.systemdesign.lld.snakeladder.user.Player;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class Game {
    private final GameProcessor gameProcessor;
    private final DefaultDice dice;
    private AtomicBoolean STOP = new AtomicBoolean(false);

    public Game(List<Player> players, int numOfWinners, int boardSize, DefaultDice dice) {
        this.gameProcessor = new GameProcessor(players, boardSize, numOfWinners);
        this.dice = dice;
    }

    public void start(){
        while (!STOP.get()){
            int diceValue = dice.roll();

            Move position = gameProcessor.move(diceValue);
            display(position);

        }
    }

    private void display(Move move) {
        System.out.println(move.getPlayer().getName() + " rolled a " + move.getNumOfMoves() + " and moved from " + move.getOldPosition() +" to " + move.getNewPosition());
    }

    public void stop(){
        STOP.set(true);
    }

}
