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
    /** czy gra jest zapalzowana*/
    Boolean isGamePaused=false;
    private Timer timer;
    @Override
    /**
     * funkcja obslugujaca przyciski
     */
    public void keyPressed(KeyEvent keyEvent) {
        /**czas gry*/
        timer=Game.getGame().getTimer();
        /**przycik ktory obsugujemy*/
        int key = keyEvent.getKeyCode();
        Game game = Game.getGame();
        //System.out.println("gotgame");
        Player player = game.getPlayer();
        /**jezeli wcisniemy esc to wylaczymy gre*/
        if (key == KeyEvent.VK_ESCAPE)
            System.exit(0);
        /**pod przyciskiem pause mamy zatrzymanie gry*/
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
         if(isGamePaused == false) {
             if (key == KeyEvent.VK_LEFT) {
                 player.setX(player.getX() - 1);

             }
             if (key == KeyEvent.VK_RIGHT) {
                 player.setX(player.getX() + 1);

             }
         }
         /**pod przyciskiem R mamy restart*/
        if (key == KeyEvent.VK_R)
        {

            Game.getGame().setRestartGame(true);
            timer.start();

        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
