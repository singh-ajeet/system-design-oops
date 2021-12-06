package org.ajeet.learnings.systemdesign.lld.snakeladder.model;

import java.util.HashMap;
import java.util.Map;

public abstract class CellObject {
    private final int source;
    private final int destination;
    private final CellObjectType type;

    private final Map<String, Object> properties;

    public CellObject(int source, int destination, CellObjectType type) {
        this(source, destination, type, null);
    }

    public CellObject(int source, int destination, CellObjectType type, Map<String, Object> properties) {
        this.source = source;
        this.destination = destination;
        this.type = type;
        this.properties = properties == null ? new HashMap<>() : properties;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    public CellObjectType getType() {
        return type;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public Object getPropertyByName(String name) {
        return properties.get(name);
    }
}
