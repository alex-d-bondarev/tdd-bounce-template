package org.practice.app;

import org.practice.app.gfx.Sprites;
import org.practice.app.gfx.Display;
import org.practice.app.input.KeyManager;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game {
    private BufferStrategy bufferStrategy;
    private Display display;
    private Graphics graphics;
    private KeyManager keyManager;
    private Sprites sprites;
    private World world;

    private boolean running;
    private final int width;
    private final int height;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;

        keyManager = new KeyManager();
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        sprites = new Sprites();
        world = new World(this);
    }

    public void start() {
        running = true;
        run();
    }

    private void run(){
        int fps = 60;
        long nanoSecond = 1000000000;
        double timePerTick = nanoSecond / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;

        while (running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                delta--;
            }

            if(timer >= nanoSecond){
                timer -= nanoSecond;
            }
        }
    }

    private void render() {
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if(bufferStrategy == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        graphics = bufferStrategy.getDrawGraphics();
        graphics.clearRect(0, 0, width, height);

        world.render(graphics);

        bufferStrategy.show();
        graphics.dispose();
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
