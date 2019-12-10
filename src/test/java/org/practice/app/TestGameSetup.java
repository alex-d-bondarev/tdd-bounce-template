package org.practice.app;

public class TestGameSetup {
    public Game generateGame(){
        String title = "Game Test";
        int width = 640;
        int height = 480;
        return new Game(title, width, height);
    }
}
