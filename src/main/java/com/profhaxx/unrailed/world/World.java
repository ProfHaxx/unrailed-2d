package com.profhaxx.unrailed.world;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import java.util.ArrayList;
import java.util.Random;

import com.profhaxx.unrailed.overlay.inventory.Item;
import com.profhaxx.unrailed.overlay.inventory.ItemTool;
import com.profhaxx.unrailed.App;

public class World extends JPanel {
    Color[] palette = new Color[]{
        new Color(0x2f8a08), //Green
        new Color(0x30bfdb), //Lightblue
        new Color(0xb2ecf7), //Extreme-Lightblue
        new Color(0x737d80), //Gray
        new Color(0x806010)  //Brown
    };
    
    public int cmpsize = 32;
    int clusterSize = 5;
    Player player;

    ArrayList<GameObject> objects = new ArrayList<>();

    public void init() {
        generate();
        player = new Player(this, 0, 0, 's');
        System.out.println("Generated " + objects.size() + " objects!");
    }

    public void forceSpawn(GameObject o) {
        for(GameObject oi:objects) {
            if(o.isOn(oi)) {
                objects.remove(oi);
                objects.add(o);
                return;
            } 
        }
        objects.add(o);
    }

    public GameObject objAt(int x, int y) {
        for(GameObject oi:objects) {
            if(oi.isOn(x,y)) return oi;
        }
        return null;
    }

    public void breakBlock(Player p, Item sel) {

        int[] xi = new int[3];
        int[] yi = new int[3];

        if(p.getOrientation() == 'n' || p.getOrientation() == 's') {
            xi[0] = 0;
            xi[1] = -1;
            xi[2] = +1;
        } else if(p.getOrientation() == 'w') {
            xi[0] = -1;
            xi[1] = -1;
            xi[2] = -1;
        } else {
            xi[0] = 1;
            xi[1] = 1;
            xi[2] = 1;
        }

        if(p.getOrientation() == 'w' || p.getOrientation() == 'e') {
            yi[0] = 0;
            yi[1] = -1;
            yi[2] = 1;
        } else if(p.getOrientation() == 'n') {
            yi[0] = -1;
            yi[1] = -1;
            yi[2] = -1;
        } else {
            yi[0] = 1;
            yi[1] = 1;
            yi[2] = 1;
        }

        if(sel.getName().equals("pickaxe") && !((ItemTool) sel).isBroken()) {
            for(int i = 0; i < 3; i++) {
                if(objAt(p.x + xi[i], p.y + yi[i]) instanceof RockDeposit) { 
                    ((Breakable)objAt(p.x + xi[i], p.y + yi[i])).breakBlock(p);
                    ((ItemTool) sel).decreaseDurability();
                    break;
                }
            }
        }
        if(sel.getName().equals("bucket") && !(((ItemTool) sel).getDurability() >= 1)) {
            for(int i = 0; i < 3; i++) {
                if(objAt(p.x + xi[i], p.y + yi[i]) instanceof LakeSource) {
                    ((Breakable)objAt(p.x + xi[i], p.y + yi[i])).breakBlock(p);
                    ((ItemTool) sel).increaseDurability();
                    break;
                }
            }
        }
        if(sel.getName().equals("axe") && !((ItemTool) sel).isBroken()) {
            for(int i = 0; i < 3; i++) {
                if(objAt(p.x + xi[i], p.y + yi[i]) instanceof ForestTree) {
                    ((Breakable)objAt(p.x + xi[i], p.y + yi[i])).breakBlock(p);
                    ((ItemTool) sel).decreaseDurability();
                    break;
                }
            }
        }
    }

    public void spawn(GameObject o) {
        for(GameObject oi:objects) {
            if(o.isOn(oi)) return;
        }
        objects.add(o);
    }

    public boolean move(GameObject o, int x, int y) {
        for(GameObject oi:objects) {
            if(oi.isOn(x,y) && !o.equals(oi)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void update(Graphics g) {
        System.out.println("[DEBUG] Update...");
        Graphics offGraphics;
        Image offScreen = null;
        Dimension d = size();

        offScreen = createImage(d.width, d.height);
        offGraphics = offScreen.getGraphics();

        offGraphics.setColor(getBackground());
        offGraphics.fillRect(0, 0, d.width, d.height);
        offGraphics.setColor(getForeground());

        paint(offGraphics);

        g.drawImage(offScreen, 0, 0, this);
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("[DEBUG] Paint...");
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(palette[0]);
        g2d.fillRect(0,0,App.WIDTH,App.HEIGHT);

        for(GameObject o:objects) o.paint(g2d);
    }

    public void generate() {
        /*
         * Chances to spawn:
         * Forest => (4 per 48*27 = 1296)
         * Rock Vein => (4 per 1296)
         * Lake => (2 per 1296)
         */

        Random random = new Random();

        for(int i = 0; i < 48; i++) {
            for(int j = 0; j < 27; j++) {
                double num = random.nextDouble();

                if(num <= 4.0/1296.0) {
                    System.out.println("Generating Forest @(" + i + "|" + j + ")");
                    ForestGenerator.generate(this, i, j);
                } else if(num > 4.0/1296.0 && num <= 8.0/1296.0) {
                    System.out.println("Generating Rock Vein @(" + i + "|" + j + ")");
                    RockGenerator.generate(this, i, j);
                } else if(num > 8.0/1296.0 && num <= 10.0/1296.0) {
                    System.out.println("Generating Lake @(" + i + "|" + j + ")");
                    LakeGenerator.generate(this, i, j);
                }
            }
        }
    }

    public Player getPlayer() {
        return player;
    }
}
