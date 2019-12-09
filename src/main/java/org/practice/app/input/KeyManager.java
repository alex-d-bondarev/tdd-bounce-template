package org.practice.app.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    private boolean upKeyPressed;

    public KeyManager() {
        keys = new boolean[256];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {
            return;
        }
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {
            return;
        }
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void tick() {
        upKeyPressed = keys[KeyEvent.VK_UP];
    }

    public void pressKey(int key) {
        keys[key] = true;
        tick();
    }

    public void releaseKey(int key) {
        keys[key] = false;
        tick();
    }

    public boolean isUpKeyPressed() {
        return upKeyPressed;
    }
}
