package com.company.logic;

import com.company.Game;
import com.company.util.PropertiesReader;
import com.company.util.ServerConector;
import java.util.Timer;
import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Player - gracz
 */
public class Player {
    /**liczba zyc*/
    private int nrOfLifes;
    /**maksymalna liczba zyc*/
    private int maxNrOfLifes;
    /**wynik*/
    private int score;
    /**wspolrzedne gracza*/
    private int x,y;
    /**nick*/
    private String nick;
    /**wyglad gracza*/
    private int carImage=0;
    /**czy wygral*/
    private boolean isWin = false;
    /**czy jest niezniszlany*/
    private boolean isUnBreakable = false;
    /**czas przez jaki jest niezniszalny*/
    private Timer timeOfBeingUnbreakable;
    /**wystartowanie czasu*/
    private long startTime;

    /**
     * kostruktor klasy Player
     */
    public Player(){
        //pobieranie informacji z xml
            PropertiesReader propertiesReader = new PropertiesReader("properties.xml");
        /**zczytanie liczby zyc z pliku*/
            nrOfLifes = propertiesReader.getPropertyValueInt("lifes");
        /**ustawienie maksymalnej liczy zyc*/
        this.maxNrOfLifes = nrOfLifes;
        /**ustawienie poczatkowych wpolrzednych*/
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
        /**
         * petla wyszukujaca 7 na planszy ktora oznacza wspolrzedna X w jakiej zacznie gracz
         */
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

    /**
     * funkcja przesowajaca gracza
     */
    public void advancePlayer()
    {
        this.y++;
    }

    /**
     * funkcja pobierajaca maksymalna liczbe zyc
     * @return maksymalna liczbe zyc
     */
    public int getMaxNrOfLifes() {
        return maxNrOfLifes;
    }

    /**
     * ustawianie maksymalnej liczby zyc
     * @param maxNrOfLifes maksymalna liczba zyc
     */
    public void setMaxNrOfLifes(int maxNrOfLifes) {
        this.maxNrOfLifes = maxNrOfLifes;
    }

    /**
     * funkcja ktora mowi ze gracz wygrał
     * @return wygrana
     */
    public boolean isWin() {
        return isWin;
    }

    /**
     * funkcja ustawiajaca czy wygralismy
     * @param win
     */
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

    /**
     * sprawdzenie czy użytkownik jest odporny na przeszkody - kamienie
     * @return true - odporny, false - nie
     */
    public boolean isUnBreakable() {
        return isUnBreakable;
    }

    /**
     * ustawienie odporności uzytkownikowi
     * @param unBreakable true - odporny, false - nie
     */
    public void setUnBreakable(boolean unBreakable) {
        isUnBreakable = unBreakable;
    }

    /**
     * pobranie timera dla bycie odpornym na zniszenia
     * @return timer
     */
    public Timer getTimeOfBeingUnbreakable() {
        return timeOfBeingUnbreakable;
    }

    /**
     * ustawienie timera
     * @param timeOfBeingUnbreakable
     */
    public void setTimeOfBeingUnbreakable(Timer timeOfBeingUnbreakable) {
        this.timeOfBeingUnbreakable = timeOfBeingUnbreakable;
    }

    /**
     * pobranie czasu startu odmierzania
     * @return
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * ustawienia startu odmierzania
     * @param startTime
     */
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

}
