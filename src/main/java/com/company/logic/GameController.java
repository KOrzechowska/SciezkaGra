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
    /** gracz*/
    Player player;
    /**sciezka*/
    Course course;

    /**
     * konstruktor klasy GameController
     */
    public GameController() {
        player = getGame().getPlayer();
        course = getGame().getCourse();
    }

    /**
     * funkcja sprawdzajaca czy nastapila kolizja
     */
    public void checkCollisions() {

        Block collisionBlock = getBlockUnderCar();
        if (collisionBlock != null) {
            collisionBlock.collide();
        }
    }

    /**
     * funkcja restartujaca gre
     * @param playingField miejsce rozgrywki
     */
    public void checkForRestart(PlayingField playingField) {
        /** jezeli gra jest restatowana*/
        if (Game.getGame().isRestartGame()) {
            /**inicjujemy gre */
            playingField.initGame();
            /**ustawiamy reset na false*/
            Game.getGame().setRestartGame(false);
        }
    }

    /**
     * zapis wyniku
     */
    public void saveScore(){
        /**tworzenie listy wynikow*/
        HighScores highScores = new HighScores();
        try {
            /**pobieranie listy wyniku z pliku */
            highScores.loadHighScores();
            /**sprawdzanie czy sie udalo*/
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /**dodanie wyniku do listy wynikow*/
        highScores.addToHighScoreList();
        try {
            /**zapis nowej listy do listy wynikow*/
            highScores.saveHighScores();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public Block getBlockUnderCar(){
        Player player = Game.getGame().getPlayer();
        Block block = Game.getGame().getCourse().getBlock(player.getX()-48, player.getY());
        Block block2 = Game.getGame().getCourse().getBlock(player.getX(), player.getY());
        if(block.getClass()!=BlockCourse.class)
            return block;
        else if ( block2.getClass()!=BlockCourse.class)
            return block2;
        else return null;

    }
}
