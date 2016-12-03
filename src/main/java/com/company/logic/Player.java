package com.company.logic;

import com.company.util.PropertiesReader;

/**
 * Player - gracz
 */
public class Player {
    /** liczba zyc */
    int nrOfLifes;
    /** wynik gracza */
    int score;

    public Player(){
        PropertiesReader propertiesReader = new PropertiesReader("properties.xml");
        nrOfLifes = propertiesReader.getPropertyValueInt("lifes");
    }

    public int getNrOfLifes() {
        return nrOfLifes;
    }

    public void setNrOfLifes(int nrOfLifes) {
        this.nrOfLifes = nrOfLifes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
