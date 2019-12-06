package org.practice.app;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class GameTest
{

    @Test
    public void gameCanBeCreated()
    {
        String titie = "Bouncing ball";
        int width = 640;
        int height = 480;
        Game game = new Game(titie, width, height);
        assertNotNull(game);
    }
}
