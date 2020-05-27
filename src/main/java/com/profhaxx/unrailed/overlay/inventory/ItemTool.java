package com.profhaxx.unrailed.overlay.inventory;

import java.awt.Graphics2D;

public class ItemTool extends Item {

    int durability;

    public ItemTool(Inventory inv, String name, int durability) {
        super(inv, name, 1);
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }

    public void paint(Graphics2D g) {
        
    }

    public void add(Item i) {
        this.durability += ((ItemTool) i).durability;
    }

    public static ItemTool AXE(Inventory inv) {
        return new ItemTool(inv, "axe", 64);
    }

    public static ItemTool PICKAXE(Inventory inv) {
        return new ItemTool(inv, "pickaxe", 64);
    }

    public static ItemTool EMPTY_BUCKET(Inventory inv) {
        return new ItemTool(inv, "bucket", 0);
    }
}
