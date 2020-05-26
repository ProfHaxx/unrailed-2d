package com.profhaxx.unrailed.world;

import java.awt.Graphics2D;

public abstract class DirectionalGameObject extends GameObject {
    char orientation;
    public DirectionalGameObject(World world, int x, int y, char orientation) {
        super(world, x, y);
        this.orientation = orientation;
    }

    public void setOrientation(char c) {
        this.orientation = c;
    }

    public char getOrientation() {
        return orientation;
    }

    public abstract void move(int dx, int dy, boolean relative);
    public abstract void paint(Graphics2D g);
}
