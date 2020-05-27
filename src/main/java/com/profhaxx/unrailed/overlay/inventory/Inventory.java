package com.profhaxx.unrailed.overlay.inventory;

import java.awt.Graphics2D;
import java.awt.Color;

import com.profhaxx.unrailed.world.Player;
import com.profhaxx.unrailed.App;

public class Inventory {
    Player owner;
    Item[] items;
    Item selected;

    public Inventory(Player owner) {
        this.owner = owner;
        items = new Item[5];
        items[0] = ItemTool.AXE(this);
        items[1] = ItemTool.PICKAXE(this);
        items[2] = ItemTool.EMPTY_BUCKET(this);
        items[3] = new ItemMaterial(this, "wood", 0);
        items[4] = new ItemMaterial(this, "rock", 0);
        selected = items[0];
    }

    public void init() {

    }

    public void paint(Graphics2D g) {
        g.setColor(Color.RED);
        g.drawRect(App.WIDTH/3,App.HEIGHT/4, App.WIDTH/3, App.HEIGHT/2);
    }

    public void add(Item item) {
        for(Item i:items) {
            if(i != null && i.getName().equals(item.getName())) {
                i.add(item);
            }
        }
    }

    public Item getSelected() {
        return selected;
    }

    public void select(int i) {
        selected = items[i];
    }

    public Item[] getItems() {
        return items;
    }
}
