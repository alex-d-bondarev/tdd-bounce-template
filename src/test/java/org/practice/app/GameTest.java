package org.practice.app;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class GameTest
{

    @Test
    public void gameCanBeCreated()
    {
        String title = "Bouncing ball";
        int width = 640;
        int height = 480;
        Game game = new Game(title, width, height);
        assertNotNull(game);
    }
}
