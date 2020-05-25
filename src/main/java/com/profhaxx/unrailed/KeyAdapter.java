package com.profhaxx.unrailed;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.profhaxx.unrailed.world.Player;

public class KeyAdapter implements KeyListener {
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        App app = App.app;
        Player player = app.getWorld().getPlayer();

        switch(keyCode) {
            case KeyEvent.VK_W:
                player.move(0,-1, true);
                break;
            case KeyEvent.VK_S:
                player.move(0,1, true);
                break;
            case KeyEvent.VK_A:
                player.move(-1,0, true);
                break;
            case KeyEvent.VK_D:
                player.move(1,0, true);
                break;
            case KeyEvent.VK_R:
                app.getWorld().repaint();
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
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
