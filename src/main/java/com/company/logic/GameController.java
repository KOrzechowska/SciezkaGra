package com.company.logic;

import com.company.Game;
import com.company.widok.MainGameField;
import com.company.widok.PlayingField;
import com.company.logic.Course;

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
    public void doControlling(){
        if(course.getBlock(player.getX(), player.getY()) != null) {
            if (course.getBlock(player.getX(), player.getY()).getClass() == BlockShoulder.class || course.getBlock(player.getX(), player.getY()).getClass() == BlockStone.class) {

                if (player.getNrOfLifes() > 0) {
                    player.setNrOfLifes(player.getNrOfLifes() - 1);
                    System.out.println("DEATH \t" + player.getNrOfLifes());
                    player.setFirstCoordinates();
                    MainGameField.getInfoBar().disabledHeart(player.getNrOfLifes());
                } else {
                    System.out.println("GAME OVER");
                }
            }
            if (course.getBlock(player.getX(), player.getY()).getClass() == BlockHeart.class) {
                BlockHeart blockHeart = (BlockHeart) course.getBlock(player.getX(), player.getY());
                if (blockHeart.isActive() == true && player.getNrOfLifes() < Game.getGame().getPlayer().getMaxNrOfLifes()) {
                    player.setNrOfLifes(player.getNrOfLifes() + 1);
                    MainGameField.getInfoBar().activateHeart(player.getNrOfLifes() - 1);
                    blockHeart.setActive(false);
                }

            }

            if (course.getBlock(player.getX(), player.getY()).getClass() == BlockCoin.class) {
                BlockCoin blockCoin = (BlockCoin) course.getBlock(player.getX(), player.getY());
                if (blockCoin.isActive() == true) {
                    player.setScore(player.getScore() + 1);
                    MainGameField.getInfoBar().setScoreArea();
                    blockCoin.setActive(false);

                }
            }
            if (course.getBlock(player.getX(), player.getY()).getClass() == BlockFinish.class) {
                BlockFinish blockCoin = (BlockFinish) course.getBlock(player.getX(), player.getY());
                if (blockCoin.isActive() == true) {
                    course.advanceLevel();
                    player.setScore(player.getScore()+50);
                    MainGameField.getInfoBar().setScoreArea();
                    MainGameField.getInfoBar().setLevelNumberArea();
                    player.setFirstCoordinates();
                    course.getPlansza();
                    blockCoin.setActive(false);

                }
            }
        }

    }

    public void checkForRestart(PlayingField playingField){
        if(Game.getGame().isRestartGame()) {
            playingField.initGame();
            Game.getGame().setRestartGame(false);
        }
    }
}
