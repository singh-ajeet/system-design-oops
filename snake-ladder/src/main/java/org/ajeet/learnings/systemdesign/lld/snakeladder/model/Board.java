package org.ajeet.learnings.systemdesign.lld.snakeladder.model;

public class Board {
    private final Cell[] cells;
    private final int size;

    public Board(int size) {
        if(size < 100)
            throw new IllegalArgumentException("Size must me 100 or greater than 100");

        this.size = size;
        this.cells = new Cell[size];
    }

    public int getSize() {
        return size;
    }
}
