package org.practice.app.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprites {

    public BufferedImage ball;
    public BufferedImage bigSpike;
    public BufferedImage blockedFinish;
    public BufferedImage bloodySpike;
    public BufferedImage bubble;
    public BufferedImage finish;
    public BufferedImage jumper;
    public BufferedImage leftBottomCorner;
    public BufferedImage leftTopCorner;
    public BufferedImage rightBottomCorner;
    public BufferedImage rightTopCorner;
    public BufferedImage ring;
    public BufferedImage scoredRing;
    public BufferedImage spike;
    public BufferedImage square;
    public BufferedImage start;

    public Sprites() {
        ball = loadImage("/sprites/ball.png");
    }

    private BufferedImage loadImage(String path){
        try {

            return ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
