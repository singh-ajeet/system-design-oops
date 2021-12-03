package org.ajeet.learnings.systemdesign.split;

public enum Split {
    EQUAL(EqualSplitter),
    EXACT(ExactSplitter),
    PERCENT(PercentSplitter);

            private final Splitter splitter;

    Split(Splitter  splitter) {
        this.splitter = splitter;
    }
}
