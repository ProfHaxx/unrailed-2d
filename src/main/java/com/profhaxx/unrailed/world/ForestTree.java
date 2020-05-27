package com.profhaxx.unrailed.world;

import java.awt.Graphics2D;

import com.profhaxx.unrailed.overlay.inventory.ItemMaterial;

public class ForestTree extends GameObject implements Breakable {
    public ForestTree(World world, int initialX, int initialY) {
        super(world, initialX, initialY);
        spawn();
    }

    public void breakBlock(Player p) {
        try {
            Thread.sleep(3000); // Break Time
        } catch(InterruptedException ignored) { }
        p.getInventory().add(new ItemMaterial(p.getInventory(), "wood", 1));
        stage.objects.remove(this);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(stage.palette[4]);
        g.fillRect(this.x*stage.cmpsize, this.y*stage.cmpsize, stage.cmpsize, stage.cmpsize);
    }
}
