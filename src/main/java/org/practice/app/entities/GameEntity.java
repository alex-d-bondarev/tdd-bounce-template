package org.practice.app.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class GameEntity {
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;

    public GameEntity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0, 0, width, height);
    }

    public void render(Graphics g) {
        g.drawImage(getSprite(),
                (int) x,
                (int) y,
                width,
                height,
                null);

//        showCollisionBoundary(g);
    }

    protected abstract Image getSprite();

    private void showCollisionBoundary(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) (x + bounds.x),
                (int) (y + bounds.y),
                bounds.width,
                bounds.height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
