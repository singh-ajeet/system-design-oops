package org.ajeet.learnings.systemdesign.lld.snakeladder.model;

import java.util.Map;

public final class Cell {
    private final int position;
    private final CellObject cellObject;

    private final Map<String, Object> properties;

    public Cell(int position, CellObject cellObject, Map<String, Object> properties) {
        this.position = position;
        this.cellObject = cellObject;
        this.properties = properties;
    }

    public Cell(int position, CellObject cellObject) {
        this(position, cellObject, null);
    }

    public int getPosition() {
        return position;
    }

    public CellObject getCellObject() {
        return cellObject;
    }
}
