package com.profhaxx.unrailed.world;

import java.awt.Graphics2D;

import com.profhaxx.unrailed.overlay.inventory.Inventory;

public class Player extends DirectionalGameObject {
    
    int x,y;
    Inventory inventory;

    public Player(World belongsTo, int initialX, int initialY, char orientation) {
        super(belongsTo, initialX, initialY, orientation);
        inventory = new Inventory(this);
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

    public void breakBlock() {
        stage.breakBlock(this, inventory.getSelected());
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(stage.palette[1]);
        g.fillRect(this.x*stage.cmpsize,this.y*stage.cmpsize,stage.cmpsize,stage.cmpsize);
    }

    public void select(int num) {
        getInventory().select(num);
    }

    public Inventory getInventory() {
        return inventory;
    }
}
