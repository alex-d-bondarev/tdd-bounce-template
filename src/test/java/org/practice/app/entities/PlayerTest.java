package org.practice.app.entities;

import org.junit.Before;
import org.junit.Test;
import org.practice.app.Game;
import org.practice.app.TestGameSetup;
import org.practice.app.World;

import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    private final double DELTA = 0.01;

    private Game game;
    private Player player;
    private World world;

    @Before
    public void setUp() {
        game = new TestGameSetup().generateGame();
        world = game.getWorld();
        player = world.getPlayer();
    }

    @Test
    public void playerHasSpeed() {
        float speed = player.getSpeed();
        assertTrue(speed > 0);
    }

    @Test
    public void playerCanChangeHorizontalPosition() {
        float newYPosition = 50f;
        player.setY(newYPosition);
        assertEquals(newYPosition, player.getY(), DELTA);
    }

    @Test
    public void playerIsWorldAware() {
        World accessibleWorld = player.getWorld();
        assertNotNull(accessibleWorld);
        assertEquals(world, accessibleWorld);
    }

    @Test
    public void playerCanTick() {
        player.tick();
    }

    @Test
    public void whenUpButtonIsPressed_playerShouldMovePerTick() {
        float playerSpeed = player.getSpeed();
        float startY = player.getY();

        game.getKeyManager().pressKey(KeyEvent.VK_UP);
        player.tick();

        float newYPosition = player.getY();
        assertTrue(playerSpeed > 0);
        assertEquals(startY - playerSpeed, newYPosition, DELTA);
    }

    @Test
    public void whenUpButtonIsUnpressed_playerShouldNotMovePerTick() {
        float startY = player.getY();

        game.getKeyManager().pressKey(KeyEvent.VK_UP);
        game.getKeyManager().releaseKey(KeyEvent.VK_UP);
        player.tick();

        float newYPosition = player.getY();
        assertEquals(startY, newYPosition, DELTA);
    }
}
