package org.ajeet.learnings.systemdesign.lld.snakeladder.model;

import java.util.Map;

public class Ladder extends CellObject {
    private final CellObjectType TYPE = CellObjectType.LADDER;

    public Ladder(int source, int destination, CellObjectType type) {
        super(source, destination, type);
    }

    public Ladder(int source, int destination, CellObjectType type, Map<String, Object> properties) {
        super(source, destination, type, properties);
    }


    public CellObjectType getTYPE() {
        return TYPE;
    }

}
