package com.company.logic;

import com.company.Game;
import com.company.util.ImageUtil;
import com.company.util.PropertiesReader;
import com.company.widok.MainGameField;
import com.company.widok.PlayingField;

import javax.swing.*;
import java.io.IOException;

/**
 * monety na ścieżce
 */
public class BlockFinish extends Block {
    public BlockFinish(int x, int y) {
        super(x, y);
        this.isActive = true;
        this.blockImage = ImageUtil.getImageIconFromFile("meta.jpg");
    }

    public void collide() {
        Course course = Game.getGame().getCourse();
        Player player = Game.getGame().getPlayer();
        PropertiesReader propertiesReader = new PropertiesReader("properties.xml");
        if (this.isActive() == true) {
            course.advanceLevel();
            player.setScore(player.getScore() + 50);
            MainGameField.getInfoBar().setScoreArea();
            MainGameField.getInfoBar().setLevelNumberArea();
            if (!propertiesReader.isNextValue("plansza", course.getLevelNumber())) {
                player.setWin(true);
                HighScores hs = new HighScores();
                try {
                    hs.loadHighScores();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                hs.addToHighScoreList();
                try {
                    hs.saveHighScores();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return;
            }
            player.setFirstCoordinates();
            course.getPlansza();
            this.setActive(false);

        }
    }
}

