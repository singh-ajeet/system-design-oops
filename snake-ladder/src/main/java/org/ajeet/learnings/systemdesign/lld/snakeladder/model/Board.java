package org.ajeet.learnings.systemdesign.lld.snakeladder.model;

import java.util.Map;

public class Board {
    private final Cell[] cells;
    private final Map<Integer, Ladder> ladders;
    private final Map<Integer, Ladder> snakes;
    private final int size;

    public Board(Map<Integer, Ladder> ladders, Map<Integer, Ladder> snakes, int size) {
        this.ladders = ladders;
        this.snakes = snakes;
        if(size < 100)
            throw new IllegalArgumentException("Size must me 100 or greater than 100");

        this.size = size;
        this.cells = new Cell[size];
    }

    public int getSize() {
        return size;
    }

    public CellObject getCellObject(int position){
        if(ladders.containsKey(position))
            return ladders.get(position);
        else
            return snakes.get(position);
    }
}
