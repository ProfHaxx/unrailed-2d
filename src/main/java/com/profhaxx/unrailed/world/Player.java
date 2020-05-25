package com.profhaxx.unrailed.world;

import java.awt.Graphics2D;

public class Player extends GameObject {
    int x,y;
    public Player(World belongsTo, int initialX, int initialY) {
        super(belongsTo, initialX, initialY);
    }
    
    public void move(int dx, int dy, boolean relativeMovement) {
        if(relativeMovement) {
            this.x += dx;
            this.y += dy;
        } else {
            this.x = x;
            this.y = y;
        }
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(stage.palette[1]);
        g.fillRect(this.x*stage.cmpsize,this.y*stage.cmpsize,stage.cmpsize,stage.cmpsize);
    }
}
