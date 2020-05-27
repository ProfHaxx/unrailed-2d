package com.profhaxx.unrailed.overlay.inventory;

import java.awt.Graphics2D;
import java.awt.Color;

import com.profhaxx.unrailed.world.World;
import com.profhaxx.unrailed.world.Player;
import com.profhaxx.unrailed.App;

public class Inventory {
    Player owner;
    Item[] items;
    Item selected;
    public int visible = 0;
    int debug = 0;

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
        World world = App.app.getWorld();

        g.setColor(Color.WHITE);
        //System.out.println("[DEBUG] Component Size: " + App.app.getWorld().cmpsize);
        g.fillRect(App.WIDTH/4, App.HEIGHT-2*visible*world.cmpsize, App.WIDTH/2, 2*world.cmpsize);
        g.fillRect(App.WIDTH/4, (int) (App.HEIGHT-2.5*debug*world.cmpsize), App.WIDTH/2, 2*world.cmpsize);

        g.setColor(Color.BLACK);
        boolean empty = ((ItemTool) items[2]).getDurability() == 0;
        g.drawString(
                "Selected Item: " + selected.getName() + "[" + ((ItemTool) selected).getDurability() + 
                "], Wood: " + items[3].getQuantity() + ", Rock: " + items[4].getQuantity() + ", Water: " + 
                (empty ? "empty" : "full"), 
                (int) (App.WIDTH/4 + world.cmpsize), 
                (int) (App.HEIGHT - visible*1.25*world.cmpsize)
                );

        g.drawString(
                "Player Pos: (" + owner.getX() + "|" + owner.getY() + ")",
                (int) (App.WIDTH/4 + world.cmpsize),
                (int) (App.HEIGHT - debug*1.75*world.cmpsize)
                );
    }

    public void add(Item item) {
        for(Item i:items) {
            if(i != null && i.getName().equals(item.getName())) {
                i.add(item);
            }
        }
    }

    public void toggleUI() {
        visible = Math.abs(visible-1);
        if (debug == 1) debug = 0;
    }

    public void toggleDebug() {
        debug = Math.abs(debug-1);
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
