package com.company.logic;

import com.company.Game;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

/**
 * klasa ktorzy liste poszczegolnych wynikow
 */
public class HighScores {
    /**
     * tworzenie listy wynikow
     */
    private ArrayList<HighScore> highScoreList = new ArrayList<>();

    /**
     * funkcja zapisujaca liste wynikow do pliku
     * @throws IOException wyjatek sprawdzajacy poprawnosc zapisu
     */
    public void saveHighScores() throws IOException {
        /**tworzenie pliku do ktorego ma zostac zapisana lista*/
        FileOutputStream fos = new FileOutputStream("highscores");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(highScoreList);
        oos.close();
    }

    /**
     * funkcja odczytujaca wyniki z pliku
     * @throws IOException wyjatek sprawdzajacy poprawnosc odczytu
     * @throws ClassNotFoundException wyjatek spawdzajacy poprawnosc odczytu
     */
    public void loadHighScores() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("highscores");
        ObjectInputStream ois = new ObjectInputStream(fis);
        highScoreList = (ArrayList<HighScore>) ois.readObject();
        ois.close();
    }

    /**
     * dodawanie jednego wyniku do listy wynikow
     */
   public void addToHighScoreList() {
        Player player = Game.getGame().getPlayer();
        HighScore highScore = new HighScore(player.getScore(), player.getNick());
        for (int i = 0; i<highScoreList.size(); i++)
        {
            if(highScoreList.get(i)!=null){
                // najwyższy wynik mniejszy od obecnego
                if(highScoreList.get(i).getScore()<highScore.getScore()){
                    highScoreList.add(highScore);
                    Collections.sort(highScoreList, new comparatorHighScore());
                    if(highScoreList.size()>Commons.nrOfTopScores)
                    highScoreList.remove(highScoreList.size()-1);
                    break;
                }
            }
        }
       if(highScoreList.size()<Commons.nrOfTopScores){
           highScoreList.add(highScore);
           Collections.sort(highScoreList, new comparatorHighScore());
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
