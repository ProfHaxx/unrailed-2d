package com.profhaxx.unrailed.world;

import java.awt.Graphics2D;

public abstract class GameObject {
    World stage;
    int x, y;
    
    public GameObject(World belongsTo, int x, int y) {
        this.stage = belongsTo;
        this.x = x;
        this.y = y;
    }

    public void spawn() {
        stage.spawn(this);
    }

    public void forceSpawn() {
        stage.forceSpawn(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isOn(GameObject o) {
        return this.x == o.x && this.y == o.y;
    }

    public abstract void paint(Graphics2D g);
}
