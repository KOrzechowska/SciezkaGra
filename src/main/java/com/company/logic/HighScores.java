package com.company.logic;

import com.company.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class HighScores {
    private ArrayList<HighScore> highScoreList;

    void loadHighScores() {

    }

    void addToHighScoreList() {
        Player player = Game.getGame().getPlayer();
        HighScore highScore = new HighScore(player.getScore(), player.getNick());
        highScoreList.add(highScore);
        Collections.sort(highScoreList,new comparatorHighScore());
    }

    HighScore getHighScore(int i) {
        return highScoreList.get(i);
    }

    public class comparatorHighScore implements Comparator<HighScore> {
        @Override
        public int compare(HighScore highScore2, HighScore highScore1) {

            return highScore1.getScore().compareTo(highScore2.getScore());
        }
    }
}