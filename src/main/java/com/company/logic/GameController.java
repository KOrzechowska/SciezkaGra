package com.company.logic;

import com.company.Game;
import com.company.widok.GameInfoBar;
import com.company.widok.MainGameField;
import com.company.widok.PlayingField;

import javax.swing.*;
import java.sql.Time;
import java.util.*;
import java.util.Timer;

import static com.company.Game.getGame;

/**
 * Klasa kontrolująca przebieg gry
 * wychwytuje zdarzenia
 */
public class GameController {

    Player player;
    Course course;
    public GameController() {
        player = getGame().getPlayer();
        course = getGame().getCourse();
       System.out.println(getGame().getPlayer().getY());
        //System.out.println(Game.getGame().getCourse().getCurrentCourseBlocks().);
    }
    public void doControlling(){
        if(course.getBlock(player.getX(), player.getY()) != null) {
            //System.out.println(course.getBlock(player.getX(), player.getY()).getClass()+"\t"+player.getY()+"\t"+player.getX());
            if (course.getBlock(player.getX(), player.getY()).getClass() == BlockStone.class){//) || course.getBlock(player.getX(), player.getY()).getClass() == BlockStone.class) {

                if (player.getNrOfLifes() > 0) {
                    player.setNrOfLifes(player.getNrOfLifes() - 1);
                    System.out.println("DEATH \t"+player.getNrOfLifes());
                    player.setFirstCoordinates();
                    MainGameField.getInfoBar().disabledHeart(player.getNrOfLifes());
                } else {
                    System.out.println("GAME OVER");
                    //JFrame frame = new JFrame();
                   // JOptionPane.showMessageDialog(frame, "GAME OVER!!!");
                }
            }
           //if (course.getBlock(player.getX(), player.getY()).getClass() == BlockHeart.class) {
                //player.setNrOfLifes((player.getNrOfLifes() + 1));
                //System.out.println(player.getNrOfLifes());
              //  MainGameField.getInfoBar().activateHeart(player.getNrOfLifes());
            //}
        }

    }

    public void checkForRestart(PlayingField playingField){
        if(Game.getGame().isRestartGame()) {
            playingField.initGame();
            Game.getGame().setRestartGame(false);
        }
    }
}
