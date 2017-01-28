package com.company.logic;

import com.company.Game;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class HighScores {
    private ArrayList<HighScore> highScoreList = new ArrayList<>();

    public void saveHighScores() throws IOException {
        FileOutputStream fos = new FileOutputStream("highscores");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(highScoreList);
        oos.close();
    }

    public void loadHighScores() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("highscores");
        ObjectInputStream ois = new ObjectInputStream(fis);
        highScoreList = (ArrayList<HighScore>) ois.readObject();
        ois.close();
    }

   public void addToHighScoreList() {
        Player player = Game.getGame().getPlayer();
        HighScore highScore = new HighScore(player.getScore(), player.getNick());
        for (int i = 0; i<5; i++)
        {
            if(highScoreList.get(i)!=null){
                // najwyższy wynik mniejszy od obecnego
                if(highScoreList.get(i).getScore()<highScore.getScore()){
                    highScoreList.add(highScore);
                    Collections.sort(highScoreList, new comparatorHighScore());
                    highScoreList.remove(highScoreList.size()-1);
                }
            }
        }
    }

    HighScore getHighScore(int i) {
        return highScoreList.get(i);
    }

    public ArrayList<HighScore> getHighScoreList() {
        return highScoreList;
    }

    public void addToHighScoreList(String name, int score) {
        HighScore newHighScoreToAdd = new HighScore(score,name);
        highScoreList.add(newHighScoreToAdd);
        Collections.sort(highScoreList, new comparatorHighScore());
    }

    public class comparatorHighScore implements Comparator<HighScore> {
        @Override
        public int compare(HighScore highScore2, HighScore highScore1) {

            return highScore1.getScore().compareTo(highScore2.getScore());
        }
    }
}
