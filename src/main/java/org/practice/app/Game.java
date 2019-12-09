package org.practice.app;

import org.practice.app.gfx.Sprites;
import org.practice.app.gfx.Display;
import org.practice.app.input.KeyManager;

public class Game {
    private Display display;
    private KeyManager keyManager;
    private boolean running;

    private Sprites sprites;
    private World world;

    public Game(String title, int width, int height) {
        keyManager = new KeyManager();
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        sprites = new Sprites();
        world = new World(this);
    }

    public void start() {
        running = true;
    }

    public void tick() {
        keyManager.tick();
        world.tick();
    }

    public World getWorld() {
        return world;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public Sprites getSprites() {
        return sprites;
    }
}
