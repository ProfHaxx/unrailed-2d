package com.profhaxx.unrailed.world;

import java.awt.Graphics2D;

import com.profhaxx.unrailed.KeyAdapter;
import com.profhaxx.unrailed.overlay.inventory.ItemMaterial;

public class RockDeposit extends GameObject implements Breakable {
    public RockDeposit(World belongsTo, int initialX, int initialY) {
        super(belongsTo, initialX, initialY);
        spawn();
    }

    public void breakBlock(Player p) {
        KeyAdapter.processing = true;
        try {
            Thread.sleep(3000); // Break Time
        } catch(InterruptedException ignored) { }
        System.out.println("[DEBUG] Block broken @(" + this.x + "|" + this.y + ")");
        new ItemMaterial(p.getInventory(), "rock", 1);
        stage.objects.remove(this);
        KeyAdapter.processing = false;
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(stage.palette[3]);
        g.fillRect(this.x*stage.cmpsize, this.y*stage.cmpsize, stage.cmpsize, stage.cmpsize);
    }
}
