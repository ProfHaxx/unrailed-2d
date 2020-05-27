package com.profhaxx.unrailed.overlay.inventory;

import java.awt.Graphics2D;

public abstract class Item {
    int quantity;
    String name;
    Inventory inv;

    public Item(Inventory inv, String name, int quantity) {
        this.inv = inv;
        this.name = name;
        this.quantity = quantity;
        this.inv.add(this);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public abstract void add(Item i);
    public abstract void paint(Graphics2D g);
}
