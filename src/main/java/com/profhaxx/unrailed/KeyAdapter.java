package com.profhaxx.unrailed;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.profhaxx.unrailed.world.Player;
import com.profhaxx.unrailed.overlay.inventory.ItemTool;

public class KeyAdapter implements KeyListener {
    public static boolean processing = false;
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        App app = App.app;
        Player player = app.getWorld().getPlayer();

        System.out.println("Key pressed with: " + processing);
        if(!processing) {
            System.out.println("Key pressed and successfully processing");
            switch(keyCode) {
                case KeyEvent.VK_W:
                    player.setOrientation('n');
                    player.move(0,-1, true);
                    break;
                case KeyEvent.VK_S:
                    player.setOrientation('s');
                    player.move(0,1, true);
                    break;
                case KeyEvent.VK_A:
                    player.setOrientation('w');
                    player.move(-1,0, true);
                    break;
                case KeyEvent.VK_D:
                    player.setOrientation('e');
                    player.move(1,0, true);
                    break;
                case KeyEvent.VK_SPACE:
                    new Thread(() -> {
                        player.breakBlock();    
                    }).start();
                    break;
                case KeyEvent.VK_R:
                    app.getWorld().repaint();
                    break;
                case KeyEvent.VK_1:
                    player.select(0);
                    break;
                case KeyEvent.VK_2:
                    player.select(1);
                    break;
                case KeyEvent.VK_3:
                    player.select(2);
                    break;
                case KeyEvent.VK_4:
                    player.select(3);
                    break;
                case KeyEvent.VK_5:
                    player.select(4);
                    break;
                case KeyEvent.VK_I:
                    int[] durabilities = new int[3];
                    int[] quantities = new int[]{
                        player.getInventory().getItems()[3].getQuantity(),
                        player.getInventory().getItems()[4].getQuantity()
                    };
                    for(int i = 0; i < 3; i++) {
                        durabilities[i] = ((ItemTool) player.getInventory().getItems()[i]).getDurability();
                    }
                    System.out.println("Axe Uses: " + durabilities[0] + ", Pickaxe Uses: " + durabilities[1] + ", Buckets filled: " + durabilities[2] + ".\n" +
                        "Wood Collected: " + quantities[0] + ", Rocks collected: " + quantities[1]);
                    player.getInventory().toggleUI();
                    break;
                case KeyEvent.VK_F1:
                    player.getInventory().toggleDebug();
                    break;
                case KeyEvent.VK_ESCAPE:
                    System.exit(0);
                    break;
            }
        }
        
        app.getWorld().repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Do nothing
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Do nothing
    }
}
