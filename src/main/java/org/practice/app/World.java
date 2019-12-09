package org.practice.app;


import org.practice.app.entities.Player;

import java.awt.Graphics;

public class World {

    private Player player;

    public World() {
        player = new Player(100, 100);
    }

    public void tick() {
        player.tick();
    }

    public void render(Graphics g) {
        player.render(g);
    }

    public Player getPlayer() {
        return player;
    }
}
