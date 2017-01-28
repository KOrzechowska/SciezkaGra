package com.company.logic;

import com.company.Game;
import com.company.widok.MainGameField;
import com.company.widok.PlayingField;
import com.company.logic.Course;

import java.io.IOException;

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
    }

    public void checkCollisions() {

        Block collisionBlock = course.getBlock(player.getX(), player.getY());
        if (collisionBlock != null) {
            collisionBlock.collide();
        }
    }


    public void checkForRestart(PlayingField playingField) {
        if (Game.getGame().isRestartGame()) {
            playingField.initGame();
            Game.getGame().setRestartGame(false);
        }
    }

    public void saveScore(){
        HighScores highScores = new HighScores();
        try {
            highScores.loadHighScores();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        highScores.addToHighScoreList();
        try {
            highScores.saveHighScores();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
