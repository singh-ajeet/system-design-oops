package org.ajeet.learnings.systemdesign.lld.snakeladder.model;

import java.util.Map;

public class Snake extends CellObject {
    private final CellObjectType TYPE = CellObjectType.SNAKE;

    public Snake(int source, int destination, CellObjectType type) {
        super(source, destination, type);
    }

    public Snake(int source, int destination, CellObjectType type, Map<String, Object> properties) {
        super(source, destination, type, properties);
    }

    public CellObjectType getTYPE() {
        return TYPE;
    }
}
