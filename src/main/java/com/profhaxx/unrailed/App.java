package com.profhaxx.unrailed;

import javax.swing.JFrame;
import java.awt.Toolkit;

import com.profhaxx.unrailed.world.World;

public class App extends JFrame {

    public static final int WIDTH = 960;
    public static final int HEIGHT = 540;
    
    World world;

    public static App app;

    public static void main(String[] args) {
        app = new App();
        app.setup();
        app.launch();
    }

    public void setup() {
        setTitle("Unrailed 2D");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
        setVisible(true);
    }

    public void launch() {
        world = new World();
        world.init();
        
        KeyAdapter keyAdapter = new KeyAdapter();

        add(world);
        addKeyListener(keyAdapter);
    }

    public World getWorld() {
        return world;
    }
}
