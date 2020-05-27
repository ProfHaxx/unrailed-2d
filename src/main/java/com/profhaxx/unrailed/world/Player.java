package com.profhaxx.unrailed.world;

import java.awt.Graphics2D;

public class Player extends DirectionalGameObject {
    int x,y;
    public Player(World belongsTo, int initialX, int initialY, char orientation) {
        super(belongsTo, initialX, initialY, orientation);
        forceSpawn();
    }

    @Override    
    public void move(int dx, int dy, boolean relativeMovement) {
        int tX = 0, tY = 0;
        if(relativeMovement) {
            tX = this.x + dx;
            tY = this.y + dy;
        } else {
            tX = x;
            tY = y;
        }

        if(stage.move(this, tX, tY)) {
            this.x = tX;
            this.y = tY;
        }
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(stage.palette[1]);
        g.fillRect(this.x*stage.cmpsize,this.y*stage.cmpsize,stage.cmpsize,stage.cmpsize);
    }
}
