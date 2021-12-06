package org.ajeet.learnings.systemdesign.lld.snakeladder.model;

import java.util.Random;

public class DefaultDice implements Dice {
    private final Random random = new Random();

    public int roll(){
        return random.nextInt(6) + 1;
    }
}
