package com.company.logic;

import com.company.Game;
import com.company.util.PropertiesReader;
import com.company.util.ServerConector;

import java.awt.event.KeyEvent;

/**
 * Player - gracz
 */
public class Player {
    private int nrOfLifes;
    private int maxNrOfLifes;
    private int score;
    private int x,y;
    private String nick;
    private int carImage=0;
    private boolean isWin = false;

    public Player(){
        //pobieranie informacji z xml

            PropertiesReader propertiesReader = new PropertiesReader("properties.xml");
            nrOfLifes = propertiesReader.getPropertyValueInt("lifes");

        this.maxNrOfLifes = nrOfLifes;
        setFirstCoordinates();
    }

    /**
     * ustwienie początkowych współrzędnych graczy
     * - współrzędne te są czytane z pliku konfiguracyjnego
     */
    public void setFirstCoordinates(){
            // pobranie planszy z xml
            PropertiesReader propertiesReader = new PropertiesReader("properties.xml");
            String planszaStream = propertiesReader.getPropertyValue("plansza", 1);
            planszaStream = new StringBuffer(planszaStream).reverse().toString();
            int i=0;
            for(int y=-10; y<10; y++)
                for (int x=0; x<10; x++)
                {
                    int rodzajBloku = Integer.parseInt(planszaStream.substring(i, i + 1));
                    if(rodzajBloku == 7){
                        this.x = x*Commons.blockSize;
                        this.y = y;
                        System.out.println("player:\t"+x+"\t"+y);
                    }
                    i++;
                }
    }
    public void advancePlayer()
    {
        this.y++;
    }

    public int getMaxNrOfLifes() {
        return maxNrOfLifes;
    }

    public void setMaxNrOfLifes(int maxNrOfLifes) {
        this.maxNrOfLifes = maxNrOfLifes;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    /**
     * funkcja zwarvająca wybrany pojazd użytkownika
     * @return kod wybranego auta
     */

    public int getCarImage() {
        return carImage;
    }

    /**
     * ustawienie auta dla gracza
     * @param carImage - kod auta
     */
    public void setCarImage(int carImage) {
        this.carImage = carImage;
    }

    /**
     * funkcja zwracająca nazwę użtkownika
     * @return nazwa gracza
     */
    public String getNick() {
        return nick;
    }

    /**
     * ustawienie nazwy graczowi
     * @param nick - nazwa gracza
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * funkcja zwaracająca współrzedną x gracza
     * @return - współrzędna x
     */
    public int getX() {
        return x;
    }

    /**
     * ustawienie graczowi współrzędnej x
     * @param x współrzędna x gracza
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * funkcja zwracająca współrzędną y gracza
     * @return współrzędna y gracza
     */
    public int getY() {
        return y;
    }

    /**
     * ustawienie współrzędnej x użytkownika
     * @param y współrzędna y gracza
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * funkcja zwracająca liczbę żyć gracza
     * @return liczba żyć
     */
    public int getNrOfLifes() {
        return nrOfLifes;
    }

    /**
     * ustawienie liczby żyć użytkownikowi
     * @param nrOfLifes - liczba żyć
     */
    public void setNrOfLifes(int nrOfLifes) {
        this.nrOfLifes = nrOfLifes;
    }

    /**
     * funkcja zwracająca wynik gracza
     * @return - liczba zdobytych punktów
     */
    public int getScore() {
        return score;
    }

    /**
     * ustawienie graczowi liczby punktów
     * @param score - liczba zdobytych punktów
     */
    public void setScore(int score) {
        this.score = score;
    }


}
