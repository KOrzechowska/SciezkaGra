package com.company.logic;

import com.company.Game;
import com.company.widok.GameInfoBar;

/**
 * Klasa kontrolująca przebieg gry
 * wychwytuje zdarzenia
 */
public class GameController {
    GameInfoBar gameInfoBar;
    Game game;
    Player player;
    Course course;
    public GameController() {
        player = Game.getGame().getPlayer();
        course = Game.getGame().getCourse();
       System.out.println(Game.getGame().getPlayer().getY());
        //System.out.println(Game.getGame().getCourse().getCurrentCourseBlocks().);
    }
    public void doControlling(){
        if(course.getBlock(player.getX(), player.getY()) != null){
            if(course.getBlock(player.getX(), player.getY()).getClass() == BlockShoulder.class) {
                //System.out.println("asdsafgdziala");
                //int n=0;
                player.setNrOfLifes(player.getNrOfLifes()-1);
                System.out.println(player.getNrOfLifes());
                player.setFirstCoordinates();
                //gameInfoBar.disabledHeart(n);
                //n++;
            }
        }

    }
}
