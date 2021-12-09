package org.ajeet.learnings.systemdesign.lld.snakeladder;

import org.ajeet.learnings.systemdesign.lld.snakeladder.model.*;
import org.ajeet.learnings.systemdesign.lld.snakeladder.user.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class Game {
    private final GameProcessor gameProcessor;
    private final DefaultDice dice;
    private AtomicBoolean STOP = new AtomicBoolean(false);

    private Game(List<Player> players, Board board, int numOfWinners, int boardSize, DefaultDice dice) {
        this.gameProcessor = new GameProcessor(players, board,  boardSize, numOfWinners);
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

    public static Builder builder(){
        return new Builder();
    }

    private static class Builder {
        private int boardSize;
        private List<CellObject> snakes = new ArrayList<>();
        private List<CellObject> ladders = new ArrayList<>();
        private int numberOfWinners;
        private List<Player> players;

        public Game build(){
            Board board = buildBoard();
            return null;
        }

        private Board buildBoard() {
            return null;
        }

        public Builder withBoardSize(int boardSize){
            this.boardSize = boardSize;
            return this;
        }

        public Builder withSnakes(List<Snake> snakes){
            this.snakes.addAll(snakes);
            return this;
        }

        public Builder withSnake(Snake snake){
            this.snakes.add(snake);
            return this;
        }

        public Builder withLadders(List<Ladder> ladders){
            this.ladders.addAll(ladders);
            return this;
        }

        public Builder withSnakes(Ladder ladder){
            this.ladders.add(ladder);
            return this;
        }

        public Builder withNumOfWinners(int winners){
            this.numberOfWinners = winners;
            return this;
        }

        public Builder withPlayers(List<Player> players){
            this.players.addAll(players);
            return this;
        }

        public Builder withPLayer(Player pLayer){
            this.players.add(pLayer);
            return this;
        }
    }
}
