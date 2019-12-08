package org.practice.app.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends GameEntity {

    public Player(float x, float y) {
        super(x, y, 64, 64);

        bounds.x = 16;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;
    }

    public void tick() {
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(getAsset(),
                (int) x,
                (int) y,
                width,
                height,
                null);

//        showCollisionBoundary(g);
    }

    private void showCollisionBoundary(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) (x + bounds.x),
                (int) (y + bounds.y),
                bounds.width,
                bounds.height);
    }

    private BufferedImage getAsset() {
        return null;
    }
}
