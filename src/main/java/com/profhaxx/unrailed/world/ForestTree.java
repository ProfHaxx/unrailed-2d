package com.profhaxx.unrailed.world;

import java.awt.Graphics2D;

public class ForestTree extends GameObject {
    public ForestTree(World world, int initialX, int initialY) {
        super(world, initialX, initialY);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(stage.palette[4]);
        g.fillRect(this.x*stage.cmpsize, this.y*stage.cmpsize, stage.cmpsize, stage.cmpsize);
    }
}
