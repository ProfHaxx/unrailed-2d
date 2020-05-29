package com.profhaxx.unrailed.world;

import java.util.concurrent.ThreadLocalRandom;

public class GenerationTuple {
    int genCapacity, current;
    public GenerationTuple(int genCapacity, int current) {
        this.genCapacity = genCapacity;
        this.current = current;
    }

    public GenerationTuple generateSub() {
        this.decrease();
        int subGenCap = ThreadLocalRandom.current().nextInt(0, genCapacity);
        return new GenerationTuple(subGenCap, subGenCap);
    }

    public void decrease() {
        current--;
    }

    public boolean empty() {
        return current == 0;
    }

    public int getBaseCapacity() {
        return genCapacity;
    }
}
