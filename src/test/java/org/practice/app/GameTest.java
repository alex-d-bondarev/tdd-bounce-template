package org.practice.app;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.practice.app.entities.Player;
import org.practice.app.input.KeyManager;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new TestGameSetup().generateGame();
    }


    @Test
    public void gameCanBeCreated() {
        assertNotNull(game);
    }

    @Test
    public void gameHasWorld(){
        World world = game.getWorld();
        assertNotNull(world);
    }

    @Test
    public void gameWorldHasAPlayer(){
        World world = game.getWorld();
        Player player = world.getPlayer();
        assertNotNull(player);
    }

    @Test
    public void gameCanProcessKeyStrokes(){
        KeyManager keyManager = game.getKeyManager();
        assertNotNull(keyManager);
    }
}
