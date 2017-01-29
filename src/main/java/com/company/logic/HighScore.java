package com.company.logic;

import java.io.Serializable;

/**
 * klasa która tworzy pojedynczy rezultat na liscie najlepszych graczy
 */
public class HighScore implements Serializable {
    final private Integer Score;
    final private String Nick;

    /**
     * konstruktor klasy HighScore
     * @param score wynik gracza
     * @param nick nick gracza
     */
    public HighScore(Integer score, String nick)

    {
        Score = score;
        Nick = nick;
    }

    /**
     * funkcja pobierajaca wynik
     * @return wynik
     */
    public Integer getScore() {
        return Score;
    }

    /**
     * fukcja pobierajaca nick
     * @return nick
     */
    public String getNick() {
        return Nick;
    }
}
