package org.practice.app;

import org.practice.app.entities.Player;
import org.practice.app.gfx.Sprites;
import org.practice.app.input.KeyManager;

import java.awt.Graphics;

public class World {

    private Player player;
    private Game game;

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    public World(Game game) {
        this.game = game;
        player = new Player(100, 100, this);
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

    public Sprites getSprites() {
        return game.getSprites();
    }
}
