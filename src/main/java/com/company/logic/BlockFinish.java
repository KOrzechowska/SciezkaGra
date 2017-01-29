package com.company.logic;

import com.company.Game;
import com.company.util.ImageUtil;
import com.company.util.PropertiesReader;
import com.company.widok.MainGameField;
import com.company.widok.PlayingField;

import javax.swing.*;
import java.io.IOException;

/**
 * Klasa dziedzicząca po klasie Block
 */
public class BlockFinish extends Block {
    /**konstuktor klasy BlockFinish*/
    public BlockFinish(int x, int y) {
        super(x, y);
        /**standardowo blok finish jest aktywny*/
        this.isActive = true;
        /**wyglad bloku finish*/
        this.blockImage = ImageUtil.getImageIconFromFile("meta.jpg");
    }

    /**
     * funkcja opisujaca efekt zderzenia gracza z tym blokiem
     */
    public void collide() {
        Course course = Game.getGame().getCourse();
        Player player = Game.getGame().getPlayer();
        PropertiesReader propertiesReader = new PropertiesReader("properties.xml");
        /**jeżeli blok jest aktywny*/
        if (this.isActive() == true) {
            /**Poziom mapy sie zwieksza/ gracz przechodzi na nastepny poziom*/
            course.advanceLevel();
            /**przejście na nastepny poziom daje dodatkowo 50pkt*/
            player.setScore(player.getScore() + 50);
            /**odświeżenie tablicy wyniku*/
            MainGameField.getInfoBar().setScoreArea();
            /**odświeżenie tablicy pokazującej akutualnego poziomu*/
            MainGameField.getInfoBar().setLevelNumberArea();
            /**sprawdzenie czy to już ostatni poziom jezeli tak*/
            if (!propertiesReader.isNextValue("plansza", course.getLevelNumber())) {
                /**ustawienie gracza na pozycje zwycięzcy*/
                player.setWin(true);
                /**stworzenie listy wyników*/
                HighScores hs = new HighScores();
                try {
                    /**załadowanie lity wyników wynikami z pliku*/
                    hs.loadHighScores();
                    /**sprawdzenie czy sie udało*/
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                /**dodanie obecnego wyniku do listy wyników*/
                hs.addToHighScoreList();
                try {
                    /**zapis nowej listy wyników do pliku*/
                    hs.saveHighScores();
                    /**sprawdzanie czy sie udalo*/
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return;
            }
            /**ustawienie początkowej pozycji gracza*/
            player.setFirstCoordinates();
            /**wczytanie poziomu nastepnego*/
            course.getPlansza();
            this.setActive(false);

        }
    }
}

