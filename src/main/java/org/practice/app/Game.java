package org.practice.app;

import org.practice.app.gfx.Sprites;
import org.practice.app.gfx.Display;
import org.practice.app.input.KeyManager;

public class Game {
    private Display display;
    private KeyManager keyManager;
    private boolean running;
    private int width;
    private int height;
    private String title;
    private Sprites sprites;
    private World world;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;

        keyManager = new KeyManager();
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        sprites = new Sprites();
        world = new World();
    }

    public void start() {
        running = true;
    }

    private void tick() {
        keyManager.tick();
        world.tick();
    }

    public World getWorld() {
        return world;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
}
