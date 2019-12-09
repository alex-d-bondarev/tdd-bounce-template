package org.practice.app.sprites;

import org.junit.Assert;
import org.junit.Test;
import org.practice.app.gfx.Sprites;

public class SpritesTest {

    @Test
    public void spritesCanBeInitialized(){
        Sprites sprites = new Sprites();
        Assert.assertNotNull(sprites);
    }
}
