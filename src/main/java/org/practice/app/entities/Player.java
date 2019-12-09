package org.practice.app.entities;

import org.practice.app.World;
import org.practice.app.input.KeyManager;

import java.awt.image.BufferedImage;

public class Player extends GameEntity {

    private float speed = 1;
    private World world;
    private KeyManager keyManager;
    private final BufferedImage playerSprite;

    public Player(float x, float y, World world) {
        super(x, y, 64, 64);

        bounds.x = 16;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;

        this.world = world;
        keyManager = world.getKeyManager();
        playerSprite = world.getSprites().ball;
    }

    public void tick() {
        if (keyManager.isUpKeyPressed()) {
            y = y - speed;
        }
    }

    public float getSpeed() {
        return speed;
    }

    protected BufferedImage getSprite() {
        return playerSprite;
    }

    public World getWorld() {
        return world;
    }
}
