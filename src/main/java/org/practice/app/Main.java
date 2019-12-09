package org.practice.app;

public class Main {

    public static void main(String[] args) {
        String title = "Bouncing ball";
        int width = 640;
        int height = 480;
        Game game = new Game(title, width, height);
        game.start();
    }
}
