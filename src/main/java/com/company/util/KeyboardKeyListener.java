package com.company.util;

import com.company.Game;
import com.company.logic.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * klasa obsługująca przyciski
 */
public class KeyboardKeyListener extends KeyAdapter {
//    #TODO Zaimplementować metody obsługi przycisków
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        Game game = Game.getGame();
        Player player = game.getPlayer();
        System.out.println("asdsad");
        if (key == KeyEvent.VK_LEFT) {
            System.out.println("asdsad");
            player.setX(player.getX()-1);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        System.out.println("asdsad");

    }
}
