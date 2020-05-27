package com.profhaxx.unrailed.overlay.inventory;

import java.awt.Graphics2D;

public class ItemMaterial extends Item {
    public ItemMaterial(Inventory inv, String name, int quantity) {
        super(inv, name, quantity);
    }

    public void add(Item i) {
        this.quantity += i.getQuantity();
    }

    public void paint(Graphics2D g) {

    }
}
