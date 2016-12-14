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
    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        Game game = Game.getGame();
        System.out.println("gotgame");
        Player player = game.getPlayer();
        player.handleKeys(keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
