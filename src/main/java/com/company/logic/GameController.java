package com.company.logic;

import com.company.Game;

/**
 * Klasa kontrolująca przebieg gry
 * wychwytuje zdarzenia
 */
public class GameController {
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
            if(course.getBlock(player.getX(), player.getY()).getClass() == BlockShoulder.class)
                System.out.println("asdsafgdziala");
        }

    }
}
