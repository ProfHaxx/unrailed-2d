package com.profhaxx.unrailed.world;

import java.awt.Graphics2D;

import com.profhaxx.unrailed.overlay.inventory.ItemTool;

public class LakeSource extends GameObject implements Breakable {
    public LakeSource(World belongsTo, int initialX, int initialY) {
        super(belongsTo, initialX, initialY);
        spawn();
    }

    public void breakBlock(Player p) {
        try {
            Thread.sleep(3000); // Break Time
        } catch(InterruptedException ignored) { }
        new ItemTool(p.getInventory(), "bucket", 1);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(stage.palette[2]);
        g.fillRect(this.x*stage.cmpsize, this.y*stage.cmpsize, stage.cmpsize, stage.cmpsize);
    } 
}
