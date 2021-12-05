package org.ajeet.learnings.systemdesign.split;

public enum Split {
    EQUAL("EQUAL", EqualSplitter.getInstance());

    private final String name;
    private final Splitter splitter;

    private Split(String name, Splitter splitter) {
        this.name = name;
        this.splitter = splitter;
    }

    public static Split findByName(String name){
        for(Split split : values()){
            if(split.name.equals(name))
                return split;
        }
        throw new IllegalArgumentException("Invalid split type.");
    }

    public Splitter getSplitter() {
        return splitter;
    }
}
