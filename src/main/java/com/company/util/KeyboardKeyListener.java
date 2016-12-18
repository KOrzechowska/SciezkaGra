package com.company.util;

import com.company.Game;
import com.company.logic.Player;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * klasa obsługująca przyciski
 */
public class KeyboardKeyListener extends KeyAdapter {
    //    #TODO Zaimplementować metody obsługi przycisków
    Boolean isGamePaused=false;
    private Timer timer;
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        timer=Game.getGame().getTimer();
        int key = keyEvent.getKeyCode();
        Game game = Game.getGame();
        System.out.println("gotgame");
        Player player = game.getPlayer();
        player.handleKeys(keyEvent);
        if (key == KeyEvent.VK_ESCAPE)
            System.exit(0);
        if(key == KeyEvent.VK_PAUSE)
            if (isGamePaused)
            {
                isGamePaused=false;
                timer.start();
            }
            else{
                isGamePaused=true;
                timer.stop();
            }
        if(key == KeyEvent.VK_LEFT)
        {
            player.setX(player.getX()-1);

        }
        if(key == KeyEvent.VK_RIGHT)
        {
            player.setX(player.getX()+1);

        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
