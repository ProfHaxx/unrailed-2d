package com.profhaxx.unrailed.world;

import java.awt.Graphics2D;

public class RockDeposit extends GameObject {
    public RockDeposit(World belongsTo, int initialX, int initialY) {
        super(belongsTo, initialX, initialY);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(stage.palette[3]);
        g.fillRect(this.x*stage.cmpsize, this.y*stage.cmpsize, stage.cmpsize, stage.cmpsize);
    }
}
