package com.profhaxx.unrailed.world;

import java.awt.Graphics2D;

public class LakeSource extends GameObject {
    public LakeSource(World belongsTo, int initialX, int initialY) {
        super(belongsTo, initialX, initialY);
        spawn();
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(stage.palette[2]);
        g.fillRect(this.x*stage.cmpsize, this.y*stage.cmpsize, stage.cmpsize, stage.cmpsize);
    } 
}
